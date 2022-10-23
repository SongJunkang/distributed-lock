package com.atguigu.demo;

import java.util.Comparator;
import java.util.function.Supplier;

public class LambdaDemo {

    /**
      * 常用的函数式接口
      * Supplier->供应商
      * Consumer->消费者
      * Predicate->断言
      * Function->函数
      * 
      * @since 2021-10-22-10:04 AM
      */


    public static void main(String[] args) {

        Supplier supplier = () ->"TestSupplier";
        Supplier supplier2= new Supplier() {
            @Override
            public String  get() {
                return "TestSupplier";
            }
        };


//        int compare = Comparator.compare(supplier.get(), supplier2.get());

//        Non-static method 'compare(T, T)' cannot be referenced from a static context
//        无法从静态上下文引用非静态方法“compare（T，T）”

        boolean eq = supplier.get().equals(supplier2.get());
        boolean eq2 = supplier.equals(supplier2);
        System.out.println("supplier的值为：" + supplier);
        System.out.println("supplier2的值为：" + supplier2);

        System.out.println("此get方法是否相同：" + eq);
        System.out.println("此构造方法是否相同：" + eq2);

    }
}
