package com.googlecode.excavator.demo.core.manager;

import com.googlecode.excavator.demo.core.ErrorCodeException;

/**
 * 格式化
 */
public interface FormatManager {

    /**
     * 对字符串进行格式化
     *
     * @param format 格式化模版
     * @param args   参数列表
     * @return 格式化后的字符串
     * @throws ErrorCodeException 格式化失败抛出错误码
     */
    String format(String format, Object... args) throws ErrorCodeException;

}
