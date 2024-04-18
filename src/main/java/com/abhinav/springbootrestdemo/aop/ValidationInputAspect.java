package com.abhinav.springbootrestdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationInputAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationInputAspect.class);
    @Around("execution(* com.abhinav.springbootrestdemo.service.JobService.getJob(..)) && args(postId)")
    public Object checkNegativePostId(ProceedingJoinPoint jp, int postId) throws Throwable {

        if(postId<0){

            LOGGER.info("PostId is negative");
            postId=-postId;
            LOGGER.info("Updated PostId: "+postId);

        }

        return jp.proceed(new Object[]{postId});
    }

}
