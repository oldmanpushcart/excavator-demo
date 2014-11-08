package com.googlecode.excavator.demo;

import com.googlecode.excavator.demo.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final HelloService helloService = (HelloService) context.getBean("helloService");

        final String words = helloService.sayHello("vlinux");
        System.out.println( words );

        System.exit(0);

    }

}
