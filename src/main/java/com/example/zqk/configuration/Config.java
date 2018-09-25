package com.example.zqk.configuration;

import com.example.zqk.aop.MyAspect01;
import com.example.zqk.aop.UserServiceImpl;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

@Configuration
public class Config {

    public Config() {
        System.out.println("初始化");
    }

    @Bean
    public ProxyFactoryBean proxyFactoryBean() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        MyAspect01 myAspect01 = new MyAspect01();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(userServiceImpl);
        proxyFactoryBean.setInterceptorNames(myAspect01.getClass().getName());
        return proxyFactoryBean;
    }

}
