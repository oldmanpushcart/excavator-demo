package com.googlecode.excavator.demo.core.service.impl;

import com.googlecode.excavator.demo.common.LogException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.LogService;
import com.googlecode.excavator.demo.core.ErrorCodeException;
import com.googlecode.excavator.demo.core.manager.FormatManager;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * 日志服务默认实现
 */
public class LogServiceImpl implements LogService, InitializingBean, DisposableBean {

    /*
     * 日志文件路径
     */
    private String logFilePath;

    private FormatManager formatManager;

    /*
     * 日志文件句柄
     */
    private RandomAccessFile logFile;

    @Override
    public ResultDO<Void> info(String format, Serializable... args) throws LogException {

        final ResultDO<Void> result = new ResultDO<Void>();

        try {

            final String log = formatManager.format(format, args);
            logFile.writeBytes(log+"\n");
            result.setSuccess(true);

        }

        // 发生可处理内部错误，需要转成错误码
        catch (ErrorCodeException ece) {
            result.setSuccess(false);
            result.setErrorCode(ece.getErrorCode());
        }

        // 发生不可处理内部错误，需要外部重试
        catch (IOException e) {
            throw new LogException("log failed.", e);
        }

        return result;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (null == logFilePath
                || logFilePath.length() == 0) {
            throw new IllegalArgumentException("logFilePath was empty.");
        }
        this.logFile = new RandomAccessFile(logFilePath, "rw");
        logFile.seek(logFile.length());

    }

    @Override
    public void destroy() throws Exception {

        if (null != logFile) {
            logFile.close();
        }

    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public void setFormatManager(FormatManager formatManager) {
        this.formatManager = formatManager;
    }
}
