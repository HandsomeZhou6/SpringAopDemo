package com.example.zqk.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：增强代码类
 */

public class MyAspect01 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前");
        Object obj = methodInvocation.proceed();
        System.out.println("后");
        return obj;
    }
}
