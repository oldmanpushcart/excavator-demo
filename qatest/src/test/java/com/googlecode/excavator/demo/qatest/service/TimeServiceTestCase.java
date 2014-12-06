package com.googlecode.excavator.demo.qatest.service;

import com.googlecode.excavator.demo.client.TimeServiceClient;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.qatest.BaseTestCase;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static com.googlecode.excavator.demo.common.ErrorCodeConstants.ERROR_CODE_ILLEGAL_TIME_FORMAT;

/**
 * TimeService TestCase
 */
public class TimeServiceTestCase extends BaseTestCase {

    @Resource
    private TimeServiceClient timeServiceClient;

    @Test
    public void test_for_success() throws Exception {

        final ResultDO<String> result = timeServiceClient.now("yyyy-MM-dd");
        assertSuccess(result);
        Assert.assertTrue(result.getModule().matches("\\d{4}-\\d{2}-\\d{2}") );

    }


    @Test
    public void test_for_failed() throws Exception {

        final ResultDO<String> result = timeServiceClient.now("fuck you!");
        assertFailed(result);
        Assert.assertEquals(result.getErrorCode(), ERROR_CODE_ILLEGAL_TIME_FORMAT);

    }


}
