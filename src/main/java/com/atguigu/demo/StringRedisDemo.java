package com.atguigu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class StringRedisDemo {

    @Autowired
    private static StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args) {
        //向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set("redis", "100", 60 * 10, TimeUnit.SECONDS);
//val做-1操作
        stringRedisTemplate.boundValueOps("redis").increment(-1);
//根据key获取缓存中的val
        stringRedisTemplate.opsForValue().get("redis");
//val +1
        stringRedisTemplate.boundValueOps("redis").increment(1);
//根据key获取过期时间
        stringRedisTemplate.getExpire("redis");
//根据key获取过期时间并换算成指定单位
        stringRedisTemplate.getExpire("redis",TimeUnit.SECONDS);
//根据key删除缓存
        stringRedisTemplate.delete("redis");
//检查key是否存在，返回boolean值
        stringRedisTemplate.hasKey("redis");
//向指定key中存放set集合
        stringRedisTemplate.opsForSet().add("redis", "1","2","3");
//设置过期时间
        stringRedisTemplate.expire("redis",1000 , TimeUnit.MILLISECONDS);
//根据key查看集合中是否存在指定数据
        stringRedisTemplate.opsForSet().isMember("redis", "1");
//根据key获取set集合
        stringRedisTemplate.opsForSet().members("redis");
//验证有效时间
        Long expire = stringRedisTemplate.boundHashOps("redis").getExpire();
        System.out.println("redis有效时间："+expire+"秒");

    }


//
//    public static void main(String[] args) {
//
//
//        stringRedisTemplate.opsForValue().set("stock","5000");
//
//        Boolean stock = stringRedisTemplate.hasKey("stock");
//
//
//        System.out.println("是否有stock的key "+stock);
//
////        template not initialized; call afterPropertiesSet() before using it
//
//    }
}
