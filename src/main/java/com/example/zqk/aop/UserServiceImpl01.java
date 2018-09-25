package com.example.zqk.aop;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

public class UserServiceImpl01 {

    public void add() {
        System.out.println("jdk add");
    }

    public void del() {
        System.out.println("cglib del");
    }
}
