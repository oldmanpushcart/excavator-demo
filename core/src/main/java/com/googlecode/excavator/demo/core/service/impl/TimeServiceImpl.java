package com.googlecode.excavator.demo.core.service.impl;

import com.googlecode.excavator.demo.common.TimeException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.TimeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.googlecode.excavator.demo.common.ErrorCodeConstants.ERROR_CODE_ILLEGAL_TIME_FORMAT;
import static java.lang.String.format;

/**
 * 时间服务默认实现
 */
public class TimeServiceImpl implements TimeService {

    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public ResultDO<String> now(String format) throws TimeException {

        final ResultDO<String> result = new ResultDO<String>();

        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(format);
            final String resultStr = sdf.format(new Date());
            result.setSuccess(true);
            result.setModule(resultStr);
        } catch (Exception e) {
            if (logger.isLoggable(Level.WARNING)) {
                logger.log(Level.WARNING, format("error@now, format=%s", format), e);
            }
            result.setErrorCode(ERROR_CODE_ILLEGAL_TIME_FORMAT);
            result.setSuccess(false);
        }

        return result;
    }

}
