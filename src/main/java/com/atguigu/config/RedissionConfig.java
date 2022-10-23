package com.atguigu.config;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timer;

import java.util.concurrent.TimeUnit;

public class RedissionConfig {
//    RedissonClient redissonClient



    public static void main(String[] args) {

        Timer timer  = new HashedWheelTimer();

        timer .newTimeout(x->System.out.println("5s后执行。"),5, TimeUnit.SECONDS  );
        timer .newTimeout(x->System.out.println("10s后执行。"),10, TimeUnit.SECONDS  );

        System.out.println("主线程执行完毕。");

    }


}
