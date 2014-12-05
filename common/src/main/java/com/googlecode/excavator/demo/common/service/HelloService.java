package com.googlecode.excavator.demo.common.service;

import com.googlecode.excavator.demo.common.DemoException;
import com.googlecode.excavator.demo.common.domain.ResultDO;

/**
 * Hello Service Interface
 * Created by vlinux on 14/11/8.
 */
public interface HelloService {

    /**
     * say hello to somebody
     *
     * @param somebody somebody's name
     * @return hello words
     * @throws DemoException throw Exception when inner error
     */
    ResultDO<String> sayHello(String somebody) throws DemoException;

}
