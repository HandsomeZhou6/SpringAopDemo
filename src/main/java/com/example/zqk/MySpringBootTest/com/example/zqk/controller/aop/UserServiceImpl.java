package com.example.zqk.MySpringBootTest.com.example.zqk.controller.aop;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("jdk add");
    }

    @Override
    public void del() {
        System.out.println("cglib del");
    }
}
