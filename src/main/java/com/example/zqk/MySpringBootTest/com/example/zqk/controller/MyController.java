package com.example.zqk.MySpringBootTest.com.example.zqk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHOUQIANKUN009
 * @date 2018/9/21
 * @说明：
 */

@RestController
@RequestMapping("mytest/")
public class MyController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

}
