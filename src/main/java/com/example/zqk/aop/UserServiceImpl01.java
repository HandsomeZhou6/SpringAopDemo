package com.example.zqk.aop;

import org.springframework.stereotype.Component;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

@Component
public class UserServiceImpl01 {

    public void add() {
        System.out.println("jdk add");
    }

    public void del() {
        System.out.println("cglib del");
    }

    public String get(){
        System.out.println("get");
//        System.out.println(3/0);
        return "hello world";
    }
    public void newException(){
        System.out.println(3/0);
    }
}
