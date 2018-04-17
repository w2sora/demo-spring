package com.mvcTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

public class TestScope {

    public static void main(String... args) {
        ApplicationContext ctx = null;
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        ApplicationContext context3 = new FileSystemXmlApplicationContext("classpath:spring/applicationContext.xml");
        ApplicationContext context4 = new FileSystemXmlApplicationContext("src/main/resources/spring/applicationContext.xml");

        ctx = context1;

        Date s1 = (Date) ctx.getBean("singletonBean");
        Date s2 = (Date) ctx.getBean("singletonBean");
        Date p1 = (Date) ctx.getBean("prototypeBean");
        Date p2 = (Date) ctx.getBean("prototypeBean");

        System.out.println("单  例：s1 == s2 -> " + (s1 == s2));
        System.out.println("非单例：p1 == p2 -> " + (p1 == p2));
    }

}
