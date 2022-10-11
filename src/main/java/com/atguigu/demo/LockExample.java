package com.atguigu.demo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author joakims
 * @create 2022-10-10-20:20
 **/
public class LockExample {

    AbstractQueuedSynchronizer abstractQueuedSynchronizer ;
    Lock lock = new ReentrantLock();
    public void  test() throws InterruptedException {

//        lock.lock();

        System.out.println(Thread.currentThread().getName() +"开始执行该方法！");

        Thread.sleep(2000);
//        lock.unlock();

        //如果没有锁，那么这100个线程，直接全部运行。

    }

    public static void main(String[] args) {


        LockExample lockExample  = new LockExample();
        for (int i = 0; i < 100; i++) {

            new Thread(() ->{
                try {
                    lockExample.test();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

}
