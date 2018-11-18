package com.weiwei.controller.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import java.util.Date;

@Controller
@RequestMapping("/scope")
public class ScopeTestController {
    private static final Logger logger = LoggerFactory.getLogger(ScopeTestController.class);

    @GetMapping("/test1")
    @ResponseBody
    public String testSingleton() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        assert context != null;
        Date date1 = (Date) context.getBean("singletonBean");
        Date date2 = (Date) context.getBean("singletonBean");

        logger.info("Singleton: {}", date1 == date2);
        return String.valueOf(date1 == date2);
    }

    @GetMapping("/test2")
    @ResponseBody
    public String testPrototype() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        assert context != null;
        Date date1 = (Date) context.getBean("prototypeBean");
        Date date2 = (Date) context.getBean("prototypeBean");

        logger.info("Prototype: {}", date1 == date2);
        return String.valueOf(date1 == date2);
    }
}
