package com.example.zqk.com.example.zqk.controller;

import com.example.zqk.aop.UserServiceImpl01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

@RestController
@RequestMapping
public class MyController {

    @Autowired
    UserServiceImpl01 userService;


    @RequestMapping()
    public String hello(){
        userService.add();
        return "hello world!";
    }

}
