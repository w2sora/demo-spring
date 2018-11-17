package com.weiwei.controller.scope;

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

    @GetMapping("/test1")
    @ResponseBody
    public String testSingleton() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        assert context != null;
        Date date1 = (Date) context.getBean("singletonBean");
        Date date2 = (Date) context.getBean("singletonBean");

        System.out.println("Singleton: " + String.valueOf(date1 == date2));
        return String.valueOf(date1 == date2);
    }

    @GetMapping("/test2")
    @ResponseBody
    public String testPrototype() {
        ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        assert context != null;
        Date date1 = (Date) context.getBean("prototypeBean");
        Date date2 = (Date) context.getBean("prototypeBean");

        System.out.println("Prototype: " + String.valueOf(date1 == date2));
        return String.valueOf(date1 == date2);
    }
}
