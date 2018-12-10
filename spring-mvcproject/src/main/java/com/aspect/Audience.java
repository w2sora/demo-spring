package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Audience {
    private static final Logger log = LoggerFactory.getLogger(Audience.class);

    @Pointcut("execution(* com.aspect.Performance.perform(..))")
    public void performance() {
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            log.info("关手机");
            log.info("坐下");
            joinPoint.proceed();
            log.info("LL大法好！");
        } catch (Throwable throwable) {
            log.info("LL大法不好");
        }
    }

    // @Before("performance()")
    // public void silenceCellPhones() {
    //     log.info("Silencing cell phones.");
    // }
    //
    // @Before("performance()")
    // public void takeSeats() {
    //     log.info("Taking seats.");
    // }
    //
    // @AfterReturning("performance()")
    // public void applause() {
    //     log.info("CLAP CLAP CLAP!!!");
    // }
    //
    // @AfterThrowing("performance()")
    // public void demandRefund() {
    //     log.info("Demanding a refund.");
    // }
}
