package com.googlecode.excavator.demo.common.service;

import com.googlecode.excavator.demo.common.LogException;
import com.googlecode.excavator.demo.common.domain.ResultDO;

import java.io.Serializable;

/**
 * 日志服务
 */
public interface LogService {

    /**
     * 记录INFO级别日志
     *
     * @param format 日志模版(同String.format())
     * @param args   日志参数
     * @return 记录日志是否成功
     * @throws LogException 记录日志发生异常
     */
    ResultDO<Void> info(String format, Serializable... args) throws LogException;

}
