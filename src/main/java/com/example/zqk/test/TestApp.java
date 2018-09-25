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

    /**
     * 初级
     */
//    @Test
//    public void test03() {
//        ApplicationContext ac=new ClassPathXmlApplicationContext("./application.xml");
//        UserServiceImpl userService= (UserServiceImpl) ac.getBean("proxyFactoryBeanId");
//        userService.del();
//    }
/**
 * 初级
 */
//    @Test
//    public void test04() {
//        ApplicationContext ac=new ClassPathXmlApplicationContext("./application.xml");
//        UserService userServiceImpl01= (UserService) ac.getBean("proxyFactoryBeanId");
//        userServiceImpl01.del();
//    }


    /**
     * 中级
     */
    @Test
    public void test05() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("./application.xml");
        UserServiceImpl01 userService = (UserServiceImpl01) ac.getBean("userServiceImplId");
        userService.del();
    }

}
