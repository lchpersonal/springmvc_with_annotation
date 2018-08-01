package com.chengli.springmvc.controller;

import com.chengli.springmvc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: chengli
 * @Date: 2018/8/1 14:39
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping("/suc")
    public String success(){
        return "success";
    }
}
