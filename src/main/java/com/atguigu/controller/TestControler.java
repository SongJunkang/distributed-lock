package com.atguigu.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControler {


    @Value("song")
    private String systemName;


    @GetMapping("/access")
    public String access(){

        return String.format("系统(%s) :欢迎您光临",systemName  );
    }


}
