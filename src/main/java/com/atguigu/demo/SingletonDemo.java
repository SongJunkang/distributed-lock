package com.atguigu.demo;

public class SingletonDemo {

    //同时满足单例模式懒加载、线程安全和高性能的单例写法：
    //特点：持有自己类型的属性：类构造器私有：对外提供获取实例的静态方法。

    private volatile static SingletonDemo singletonDemo;

    private SingletonDemo(){};

    public static SingletonDemo getSingletonDemo(){

        if (singletonDemo == null){
            synchronized (SingletonDemo.class){
                if (singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }

        return singletonDemo;
    }


}
