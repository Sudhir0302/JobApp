package com.sudhir03.JobApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.sudhir03.JobApp.service.JobService.*(..))")
    public Object monitortime(ProceedingJoinPoint jp) throws Throwable {

        long st=System.currentTimeMillis();
        Object obj=jp.proceed();
        long ed=System.currentTimeMillis();

        LOGGER.info("Time Taken : "+(ed-st)+" ms");
        return obj;
    }
}
