package com.sudhir03.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    //syntax fo before : returntype,class-name.method-name(args)
    @Before("execution(* com.sudhir03.JobApp.service.JobService.*(..))")
    public void logMethodCall(){
        LOGGER.info("Method called");
    }

    @After("execution(* com.sudhir03.JobApp.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.sudhir03.JobApp.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some error "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.sudhir03.JobApp.service.JobService.*(..))")
    public void logMethodReturned(JoinPoint jp){
        LOGGER.info("Method successfully returned data "+jp.getSignature().getName());
    }
}
