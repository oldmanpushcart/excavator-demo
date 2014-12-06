package com.googlecode.excavator.demo.qatest.service;

import com.googlecode.excavator.demo.client.AsyncLogServiceClient;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.qatest.BaseTestCase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Async LogService TestCase
 */
public class AsyncLogServiceTestCase extends BaseTestCase {

    @Resource
    private AsyncLogServiceClient asyncLogServiceClient;


    @Test
    public void test_log_for_success() throws Exception {

        final String logFormat = "log info message[%s:%s!] for test.";
        final String words = "hello";
        final String names = "world";

        final ResultDO<Void> result = asyncLogServiceClient.info(logFormat, words, names);
        assertSuccess(result);

    }

}
