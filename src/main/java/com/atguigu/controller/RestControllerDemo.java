package com.atguigu.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestControllerDemo {


    @GetMapping("/testcontroller")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("1","张三");
//
//        modelAndView.addObject(map);
        modelAndView.setViewName("home");

//        return  new ModelAndView("home");

        return modelAndView;

    }
}
