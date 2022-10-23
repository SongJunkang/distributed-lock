package com.atguigu.controller;


import com.atguigu.mapper.StockMapper;
import com.atguigu.pojo.Stock;
import com.atguigu.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {


    @Autowired
    private StockService stockService;


        @GetMapping("stock/deduct")
    public String deduct(){

        this.stockService.deduct();
        return "hello stock deduct!!"  ;
    }

    @GetMapping("stock/getstock")
    public Stock getStock(){

        Stock stock = this.stockService.getStock();

        return stock ;
    }


    @GetMapping("stock/getstock/{id}")
    public Stock getStockByid(@PathVariable Integer id){

        Stock stock = stockService.getStockById(id);

        return  stock;


    }

}
