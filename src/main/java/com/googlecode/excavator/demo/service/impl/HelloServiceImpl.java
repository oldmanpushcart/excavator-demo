package com.googlecode.excavator.demo.service.impl;

import com.googlecode.excavator.demo.service.HelloService;

/**
 * the Hello Service default implement
 * Created by vlinux on 14/11/8.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String somebody) {
        return "hello " + somebody + "!";
    }

}
