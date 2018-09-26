package com.example.zqk.test;

import com.example.zqk.aop.ProxyFactory;
import com.example.zqk.aop.UserService;
import com.example.zqk.aop.UserServiceImpl;
import com.example.zqk.aop.UserServiceImpl01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：Aop代理
 */


public class TestApp {

    /**
     * 手写Jdk代理,实现接口的实现类
     */
    @Test
    public void test01() {
        UserService userService = new UserServiceImpl();
        UserService proxyUserService = (UserService) ProxyFactory.createProxy(userService);
        proxyUserService.add();
    }

    /**
     *  手写cglib代理，未实现接口的实现类
     */
    @Test
    public void test02() {
        UserService proxyUserService = (UserService) ProxyFactory.createUserService();
        proxyUserService.del();
    }

    /**
     * 初级,基于配置，只能一个代理目标类(jdk代理)
     */
    @Test
    public void test03() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./applicationContext.xml");
        UserService userService = (UserService) ac.getBean("proxyFactoryBeanId");
        userService.del();
    }

    /**
     * 初级,基于配置，只能一个代理目标类（cglib代理）
     */
    @Test
    public void test04() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./applicationContext.xml");
        UserServiceImpl01 userServiceImpl01 = (UserServiceImpl01) ac.getBean("proxyFactoryBeanId");
        userServiceImpl01.del();
    }


    /**
     * 中级,基于配置,
     */
    @Test
    public void test05() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./applicationContext.xml");
        UserServiceImpl01 userServiceImpl01 = (UserServiceImpl01) ac.getBean("userServiceImpl01");
        UserService userService = (UserService) ac.getBean("userServiceImpl");
        userServiceImpl01.del();
        userService.del();
    }

    /**
     * 高级,基于配置
     */
    @Test
    public void test06() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./applicationContext.xml");
        UserServiceImpl01 userService = (UserServiceImpl01) ac.getBean("userServiceImpl");
//        userService.add();
//        userService.del();
//        userService.get();
        userService.newException();
    }

    /**
     * 高级,基于注解
     */
    @Test
    public void test07() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./applicationContext.xml");
        UserServiceImpl01 userService = (UserServiceImpl01) ac.getBean("userServiceImpl01");
        userService.add();
//        userService.del();
//        userService.get();
//        userService.newException();

    }

}
