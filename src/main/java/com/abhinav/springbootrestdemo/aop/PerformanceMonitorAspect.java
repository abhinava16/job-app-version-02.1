package com.abhinav.springbootrestdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    public static Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.abhinav.springbootrestdemo.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start= System.currentTimeMillis();
        Object obj = jp.proceed();
        long end= System.currentTimeMillis();

        LOGGER.info("Time taken by method "+jp.getSignature().getName()+" is: "+(end-start)+" ms");

        return obj;

    }

}
