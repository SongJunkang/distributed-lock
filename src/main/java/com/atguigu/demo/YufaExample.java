package com.atguigu.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * @author joakims
 * @create 2022-10-11-18:51
 **/

@Slf4j
public class YufaExample {

    static YufaExample yufaExample = new YufaExample();
    public boolean compareNum(int a, int b) {

//        a = 1;
//        b = 3;

        return a > b ? true : false;
    }

    public static void main1(String[] args) {
        log.info("开始比大小。");
        YufaExample yufaExample1 = new YufaExample();

        boolean result = yufaExample1.compareNum(1, 2);
        System.out.println("1和2比较大小的结果是：" + result);
    }

    public int calcSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public int calcSumLambda(List<Integer> list) {
//        return list.stream().mapToInt(x -> x).sum();

        return list.stream().mapToInt(x ->x).sum();
    }
//
//    public  int reduce(int identity, int  op) {
//        return op -identity ;
//    }
//    public  int sum() {
//        return reduce(0, Integer::sum);
//    }

    public static void main(String[] args) {

        List list  = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        int result = yufaExample.calcSum(list);
        int result2 = yufaExample.calcSumLambda(list);

        boolean num = yufaExample.compareNum(result, result2);
        System.out.println("迭代验证：" +    num);
        System.out.println("总共calcSum计算大小为：" +result);
        System.out.println("总共calcSumLambda计算大小为：" +result2);

    }
}
