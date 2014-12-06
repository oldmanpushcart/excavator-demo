package com.googlecode.excavator.demo.client;

import com.googlecode.excavator.demo.common.LogException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.LogService;

/**
 * Created by vlinux on 14/12/6.
 */
public class LogServiceClient {

    private LogService logService;

    /**
     * 记录INFO级别日志
     *
     * @param format 日志模版(同String.format())
     * @param args   日志参数
     * @return 记录日志是否成功
     * @throws com.googlecode.excavator.demo.common.LogException 记录日志发生异常
     */
    public ResultDO<Void> info(String format, Object... args) throws LogException {
        return logService.info(format, args);
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }
}
