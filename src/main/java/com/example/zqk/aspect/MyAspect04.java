package com.example.zqk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/25
 * @说明：
 */

@Component
@Aspect
public class MyAspect04 {

    @Pointcut("execution(* com.example.zqk.aop.*.*(..))")
    private void pointCut(){};

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before balabala" +"=============="+ joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturn balabala" +"==============="+ result);
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before balabala");
        Object object = joinPoint.proceed();
        System.out.println("around after balabala");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void afterThrow(JoinPoint joinPoint, Exception e) {
        System.out.println("afterThrow balabala" +"==============="+ e);
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after balabala");
    }
}
