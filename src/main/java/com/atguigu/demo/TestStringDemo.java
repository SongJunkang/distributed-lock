package com.atguigu.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TestStringDemo {

    public static void main(String[] args) {
        String source = "a::1,b::2,c::3,d::4";

        String target = source.replace("::","=");

        System.out.println(target);

        String[] split = source.split("::");

        System.out.println(Arrays.toString(split));

        String source2 = "a::1,b::2,c::3,d::4";

        String target2 = source2.replace("::","=");

        String[] split2 = StringUtils.split(target2,'=');

        System.out.println(Arrays.toString(split2));


        String[] strings = {"a","b","c"};

        List list = Arrays.asList(strings);

        System.out.println(Arrays.toString(strings));
        System.out.println(list);
        Object[] objects = list.toArray();

        List<Integer> list1 = Arrays.asList(1,2,3,4);

        Object[] objects1 = list1.toArray();
        Integer[] objects2 = list1.toArray(new Integer[]{});

//        System.out.println(Arrays.toString(strings1));
        System.out.println(Arrays.toString(objects));






    }
}
