package com.googlecode.excavator.demo.qatest;

import com.googlecode.excavator.demo.common.domain.ResultDO;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vlinux on 14/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class BaseTestCase {

    @Test
    public void _test() {
        Assert.assertTrue(true);
    }


    /**
     * 断言返回值成功
     *
     * @param result 被断言返回值
     */
    protected void assertSuccess(ResultDO<?> result) {
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isSuccess());
        Assert.assertNull(result.getErrorCode());
    }

    /**
     * 断言返回值失败
     *
     * @param result 被断言返回值
     */
    protected void assertFailed(ResultDO<?> result) {
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isSuccess());
        Assert.assertNotNull(result.getErrorCode());
    }

}
