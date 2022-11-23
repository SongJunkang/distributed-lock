package com.atguigu;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@Slf4j
public class TestRedisD {



        @Autowired
        private StringRedisTemplate redisTemplate;


        @Test
        public void testhaha(){

            System.out.println("哈哈哈");
        }

        @Test
        public void getValue() {

            redisTemplate.opsForValue().set("name1","kang");

            String name1 = redisTemplate.opsForValue().get("name1");

            System.out.println("value:" + name1);

        }


}
