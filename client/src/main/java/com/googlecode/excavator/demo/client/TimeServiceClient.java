package com.googlecode.excavator.demo.client;

import com.googlecode.excavator.demo.common.TimeException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.TimeService;

/**
 * Created by vlinux on 14/12/2.
 */
public class TimeServiceClient {

    private TimeService timeService;

    public ResultDO<String> now(String format) throws TimeException {
        return timeService.now(format);
    }

    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }
}
