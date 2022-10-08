package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author joakims
 * @create 2022-09-24-21:28
 **/


@TableName("db_stock")
@Data
@Slf4j
public class Stock {

    private Long id;
    private String productCode;
    private String warehouse;

    private Integer count;

    private Integer version ;

//    private Integer stock = 5000;

}
