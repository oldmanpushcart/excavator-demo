package com.googlecode.excavator.demo.qatest;

import com.googlecode.excavator.demo.client.HelloServiceClient;
import com.googlecode.excavator.demo.common.DemoException;
import com.googlecode.excavator.demo.common.domain.ResultDO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws DemoException {

        final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final HelloServiceClient helloServiceClient = (HelloServiceClient) context.getBean("helloServiceClient");


        while(true) {
            try {
                final ResultDO<String> result = helloServiceClient.sayHello("vlinux");
                if( result.isSuccess()
                        && result.getModule() != null) {
                    System.out.println(result.getModule());
                }
                break;
            } catch(Exception e) {
                // re-try
                continue;
            }
        }

        System.exit(0);

    }
}
