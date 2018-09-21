package com.example.zqk.MySpringBootTest.com.example.zqk.controller.com.example.zqk.configuration;

import com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop.MyAspect;
import com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop.MyAspect01;
import com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop.UserService;
import com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop.UserServiceImpl;
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

    @Bean
    public UserServiceImpl getUserService() {
        return new UserServiceImpl();
    }

    @Bean
    public MyAspect getMyAspect() {
        return new MyAspect();
    }

    @Bean
    public ProxyFactoryBean getProxyFactoryBean(Class clazz) {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setInterfaces(clazz.getInterfaces());
        proxyFactoryBean.setTarget(clazz);
        proxyFactoryBean.setInterceptorNames(MyAspect01.class.getName());
        proxyFactoryBean.setOptimize(true);
        return proxyFactoryBean;
    }

}
