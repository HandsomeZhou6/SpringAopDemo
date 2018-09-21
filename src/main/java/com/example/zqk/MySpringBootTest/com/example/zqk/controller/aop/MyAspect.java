package com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：增强代码类
 */


public class MyAspect {

    public void pre() {
        System.out.println("pre balabala");
    }

    public void next() {
        System.out.println("next balabala");
    }

}
