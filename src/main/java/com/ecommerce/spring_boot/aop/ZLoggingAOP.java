package com.ecommerce.spring_boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ZLoggingAOP {

    @Before("execution(* com.ecommerce.spring_boot.controller..*(..))")
    public  void loggingMethod (JoinPoint joinPoint){
        System.out.println("Here in AOP");
        String methodName =    joinPoint.getSignature().toShortString();
        System.out.println("Calling: " + methodName);
    }
}
