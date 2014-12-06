package com.googlecode.excavator.demo.core;

/**
 * 错误码异常
 */
public class ErrorCodeException extends Exception {

    /*
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误码异常
     *
     * @param errorCode 错误码
     */
    public ErrorCodeException(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public String getErrorCode() {
        return errorCode;
    }
}
