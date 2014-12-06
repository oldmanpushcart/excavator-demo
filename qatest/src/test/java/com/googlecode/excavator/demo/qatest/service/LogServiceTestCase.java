package com.googlecode.excavator.demo.qatest.service;

import com.googlecode.excavator.demo.client.LogServiceClient;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.qatest.BaseTestCase;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static com.googlecode.excavator.demo.common.ErrorCodeConstants.ERROR_CODE_ILLEGAL_STRING_FORMAT;

/**
 * LogService TestCase
 */
public class LogServiceTestCase extends BaseTestCase {

    @Resource
    private LogServiceClient logServiceClient;

    @Test
    public void test_log_for_success() throws Exception {

        final String logFormat = "log info message[%s:%s!] for test.";
        final String words = "hello";
        final String names = "world";

        final ResultDO<Void> result = logServiceClient.info(logFormat, words, names);
        assertSuccess(result);

    }

    @Test
    public void test_log_for_failed() throws Exception {

        final ResultDO<Void> result = logServiceClient.info("this is a test %@s", "a", "b");
        assertFailed(result);
        Assert.assertEquals(result.getErrorCode(), ERROR_CODE_ILLEGAL_STRING_FORMAT);

    }

}
