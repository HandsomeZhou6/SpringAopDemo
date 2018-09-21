package com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：代理工厂
 */

public class ProxyFactory {

    //jdk代理
    final static MyAspect myAspect = new MyAspect();

    public static Object createProxy(final Object userService) {

        Object obj = Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.pre();
                        Object obj1 = method.invoke(userService, args);
                        myAspect.next();
                        return obj1;
                    }
                });
        return obj;
    }

    //cglib代理
    public static UserServiceImpl createUserService() {
        final UserServiceImpl userService = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.pre();
                Object obj = method.invoke(userService, args);
                myAspect.next();
                return obj;
            }
        });
        return (UserServiceImpl) enhancer.create();
    }

}
