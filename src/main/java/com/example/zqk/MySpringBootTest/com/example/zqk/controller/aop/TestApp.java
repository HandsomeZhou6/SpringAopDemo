package com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop;

import com.example.zqk.MySpringBootTest.com.example.zqk.controller.com.example.zqk.configuration.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */


public class TestApp {

    @Test
    public void test01() {
        UserService userService = new UserServiceImpl();
        UserService proxyUserService = (UserService) ProxyFactory.createProxy(userService);
        proxyUserService.add();
    }

    @Test
    public void test02() {
        UserService proxyUserService = (UserService) ProxyFactory.createUserService();
        proxyUserService.del();
    }

    @Test
    public void test03() {
        Config config=new Config();
        UserService userService = (UserService) config.getProxyFactoryBean(UserServiceImpl.class);
        userService.del();
    }
}
