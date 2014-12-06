package com.googlecode.excavator.demo.core.manager.impl;

import com.googlecode.excavator.demo.core.ErrorCodeException;
import com.googlecode.excavator.demo.core.manager.FormatManager;

import java.util.logging.Logger;

import static com.googlecode.excavator.demo.common.ErrorCodeConstants.ERROR_CODE_ILLEGAL_STRING_FORMAT;
import static java.util.logging.Level.WARNING;

/**
 * Created by vlinux on 14/12/6.
 */
public class FormatManagerImpl implements FormatManager {

    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public String format(String format, Object... args) throws ErrorCodeException {

        try {
            return String.format(format, args);
        } catch(Exception e) {
            if( logger.isLoggable(WARNING) ) {
                logger.log(WARNING, String.format("format string[%s] failed.", format), e);
            }
            throw new ErrorCodeException(ERROR_CODE_ILLEGAL_STRING_FORMAT);
        }

    }
}
