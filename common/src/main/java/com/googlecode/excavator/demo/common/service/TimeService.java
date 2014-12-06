package com.googlecode.excavator.demo.common.service;

import com.googlecode.excavator.demo.common.TimeException;
import com.googlecode.excavator.demo.common.domain.ResultDO;

/**
 * 时间服务
 */
public interface TimeService {

    /**
     * 获取当前服务器时间(格式化)
     *
     * @param format 日期格式化模版
     * @return 返回被格式化后的当前服务器时间字符串
     * @throws TimeException 发生内部错误抛出异常
     */
    ResultDO<String> now(String format) throws TimeException;

}
