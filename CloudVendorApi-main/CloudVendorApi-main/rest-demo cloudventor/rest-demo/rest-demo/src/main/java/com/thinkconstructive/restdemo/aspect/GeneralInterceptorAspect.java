package com.thinkconstructive.restdemo.aspect;


import jdk.jpackage.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;




@Aspect  // used for transaction and security
@Component
@Slf4j
public class GeneralInterceptorAspect {
  //  private final Logger logger = LoggerFactory.getLogger(GeneralInterceptorAspect.class);

    @Pointcut("execution(* com.thinkconstructive.restdemo.controller.*.*(..))")
    public void loggingPointCut(){

    }
    @Before("loggingPointCut")
    public void before(JoinPoint joinPoint) {

        Log.info("Before method invoked::" + joinPoint.getSignature());
    }

    @After("loggingPointCut")
    public void after(JoinPoint joinPoint) {
        Log.info("After method invoked::"+joinPoint.getSignature());
    }

}
