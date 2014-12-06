package com.googlecode.excavator.demo.common;

/**
 * 日志异常
 */
public class LogException extends Exception {

    private static final long serialVersionUID = 8662590152085441700L;

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(String message) {
        super(message);
    }
}
