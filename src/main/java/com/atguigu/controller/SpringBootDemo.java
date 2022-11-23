package com.atguigu.controller;


import com.alibaba.fastjson.JSONObject;
import com.atguigu.pojo.Stock;
import com.atguigu.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")

public class SpringBootDemo {

    @Autowired
    private StockService stockService;


    @GetMapping("/home")
    public String goToHomePage(){

        return "home";
    }

    @GetMapping({"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/stock")
    public String createStock(@RequestBody Stock stock){

        stock.setCount(1002);

        stock.setWarehouse("上海");
        stockService.save(stock);

        String s = JSONObject.toJSONString(stock);

        return s;

    }


}
