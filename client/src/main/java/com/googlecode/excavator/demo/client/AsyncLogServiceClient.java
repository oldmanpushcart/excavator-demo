package com.googlecode.excavator.demo.client;

import com.googlecode.excavator.demo.common.LogException;
import com.googlecode.excavator.demo.common.domain.ResultDO;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.format;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

/**
 * 日志信息
 */
class Log {

    private final Level level;
    private final String format;
    private final Serializable[] args;

    public Log(Level level, String format, Serializable[] args) {
        this.level = level;
        this.format = format;
        this.args = args;
    }

    public Level getLevel() {
        return level;
    }

    public String getFormat() {
        return format;
    }

    public Serializable[] getArgs() {
        return args;
    }
}

/**
 * 异步日志服务客户端
 */
public class AsyncLogServiceClient extends LogServiceClient {

    private final Logger logger = Logger.getAnonymousLogger();

    /*
     * 初始化标记
     */
    private final AtomicBoolean isInit = new AtomicBoolean(false);

    /*
     * HA日志队列
     */
    private final BlockingQueue<Log> logQueue;

    public AsyncLogServiceClient() {
        logQueue = new LinkedBlockingQueue<Log>();
    }

    /**
     * 记录INFO级别日志
     *
     * @param format 日志模版(同String.format())
     * @param args   日志参数
     * @return 记录日志是否成功
     * @throws LogException 记录日志发生异常
     */
    @Override
    public ResultDO<Void> info(String format, Serializable... args) throws LogException {

        checkInit();

        while (!logQueue.offer(new Log(INFO, format, args))) ;
        final ResultDO<Void> result = new ResultDO<Void>();
        result.setSuccess(true);
        return result;
    }

    /**
     * 检查参数配置
     */
    private void checkInit() {

        if (!isInit.get()) {
            throw new IllegalStateException("AsyncLogServiceClient was not init yet.");
        }

    }

    /**
     * 初始化异步客户端
     */
    public void init() {

        if (!isInit.compareAndSet(false, true)) {
            return;
        }

        final Thread logWriterDaemon = new Thread(new Runnable() {

            @Override
            public void run() {
                logger.info("log-writer-daemon started.");
                while (true) {

                    try {
                        final Log log = logQueue.take();

                        while (true) {

                            try {

                                final ResultDO<Void> result;
                                if (log.getLevel().equals(INFO)) {
                                    result = AsyncLogServiceClient.super.info(log.getFormat(), log.getArgs());
                                } else {
                                    if (logger.isLoggable(WARNING)) {
                                        logger.log(WARNING, format("log level[%s] not support, ignore this log", log.getLevel()));
                                    }
                                    continue;
                                }

                                if (!result.isSuccess()) {
                                    if (logger.isLoggable(WARNING)) {
                                        logger.log(WARNING, format("log failed, errorCode=%s", result.getErrorCode()));
                                    }
                                }

                                break;
                            }

                            // got an Exception need re-try
                            catch (Exception e) {
                                if (logger.isLoggable(WARNING)) {
                                    logger.log(WARNING, "log failed, need re-try", e);
                                }
                                continue;
                            }

                        }


                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }//while

            }

        }, "log-writer-daemon");

        logWriterDaemon.setDaemon(true);
        logWriterDaemon.start();

    }

}
