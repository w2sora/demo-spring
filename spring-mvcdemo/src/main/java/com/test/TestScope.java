package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

public class TestScope {

    private static final Logger logger = LoggerFactory.getLogger(TestScope.class);

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "spring-mvcdemo/src/main/webapp/WEB-INF/applicationContext.xml");

        Date date1 = (Date) context.getBean("singleton");
        Date date2 = (Date) context.getBean("prototype");
        Date date3 = (Date) context.getBean("singleton");
        Date date4 = (Date) context.getBean("prototype");

        logger.info("========== singleton: {}", date1 == date3);
        logger.info("========== prototype: {}", date2 == date4);
    }

}
