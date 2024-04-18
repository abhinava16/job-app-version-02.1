package com.abhinav.springbootrestdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

//    execution(return-type fully-qualified-class-name.method-name(args))
//    @Before("execution(* *.*(..))") //any-return-type any-class.any-method(any-number-of-args)
    @Before("execution(* com.abhinav.springbootrestdemo.service.JobService.getJob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called: " + jp.getSignature().getName());
    }

    @After("execution(* com.abhinav.springbootrestdemo.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.abhinav.springbootrestdemo.service.JobService.getJob(..))")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Ran Successful: " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.abhinav.springbootrestdemo.service.JobService.getJob(..))")
    public void logMethodError(JoinPoint jp){
        LOGGER.info("Method had some issues: " + jp.getSignature().getName());
    }

}
