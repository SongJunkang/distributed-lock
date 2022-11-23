package com.atguigu.demo;

import org.springframework.beans.BeanUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
        private static final AtomicInteger atomicInteger=new AtomicInteger();

        private static final ExecutorService   EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
        //开启线程池

        public void executeTask(Runnable runnable){

            EXECUTOR_SERVICE.execute(runnable);

//            BeanUtils.copyProperties();
        }

        public static void main(String[] args){


            A a =new A();
            try{
                atomicInteger.wait();
            } catch (InterruptedException  e){
                e.printStackTrace();
            }
            a.start();
        }
        static class A extends Thread{
            @Override
            public void run(){
                atomicInteger.notify();
                atomicInteger.lazySet(1);

                System.out.println(atomicInteger.get());
            }
        }
}

