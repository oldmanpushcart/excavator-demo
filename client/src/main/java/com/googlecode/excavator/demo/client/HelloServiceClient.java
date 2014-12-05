package com.googlecode.excavator.demo.client;

import com.googlecode.excavator.demo.common.DemoException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import com.googlecode.excavator.demo.common.service.HelloService;

/**
 * Created by vlinux on 14/12/2.
 */
public class HelloServiceClient {

    private HelloService helloService;

    public ResultDO<String> sayHello(String somebody) throws DemoException {
        return helloService.sayHello(somebody);
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
