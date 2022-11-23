package com.atguigu.controller;


import com.alibaba.fastjson.JSON;

import com.atguigu.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author liqiye
 * @description
 * @date 2019/4/18
 */
@Slf4j
@Controller
public class TestRedisController {

    private final String STUDENT_NAME = "STUDENT_NAME";


    // 可以直接使用原生的spring的RedisTemplate来操作redis
     @Resource
     private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisUtil redisUtil;


    public static void main(String[] args) {


        TestRedisController controller = new TestRedisController();


        controller.redisUtil.set("name1","song");


    }

}
