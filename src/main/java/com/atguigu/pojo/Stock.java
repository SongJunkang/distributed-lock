package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author joakims
 * @create 2022-09-24-21:28
 **/


@Repository
@TableName("db_stock")
@Data
@Slf4j
public class Stock {

    private Long id;
    private String productCode;
    private String warehouse;

    private Integer count;


    @Version
    private Integer version ;

//    private Integer stock = 5000;

}
