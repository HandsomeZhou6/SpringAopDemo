package com.example.zqk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：增强代码类
 */

public class MyAspect03 {

    public void before(JoinPoint joinPoint) {
        System.out.println("before balabala" +"=============="+ joinPoint.getSignature().getName());
    }

    public void afterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("afterReturn balabala" +"==============="+ result);
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before balabala");
        Object object = joinPoint.proceed();
        System.out.println("around after balabala");
    }

    public void afterThrow(JoinPoint joinPoint, Exception e) {
        System.out.println("afterThrow balabala" +"==============="+ e);
    }

    public void after(JoinPoint joinPoint) {
        System.out.println("after balabala");
    }
}
