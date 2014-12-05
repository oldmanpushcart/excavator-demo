package com.googlecode.excavator.demo.core.service.impl;

import com.googlecode.excavator.demo.common.DemoException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.HelloService;

/**
 * the Hello Service default implement
 * Created by vlinux on 14/11/8.
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public ResultDO<String> sayHello(String somebody) throws DemoException {

        final ResultDO<String> result = new ResultDO<String>();
        result.setModule("Hello:" + somebody + "!");
        result.setSuccess(true);

        return result;
    }
}
