package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class DistributedLockApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DistributedLockApplication.class, args);

    }

}
