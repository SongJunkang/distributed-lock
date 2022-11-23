package com.atguigu.demo;

import com.sun.javafx.collections.ImmutableObservableList;

import java.util.*;
import java.util.stream.IntStream;

public class FanXingDemo {


    public static <K, V> Map<K,V> newhashMap(K[] keys, V[] valus){

        Map<K,V> map = new HashMap<>();

        int length = Math.min(keys.length, valus.length);

        for (int i = 0; i < length; i++) {

            map.put(keys[i],valus[i]);

        }
        return map;

    }

    public static void main(String[] args) {

        Map<Integer,String> map1 = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            list.add(i);

        }
//        List<Integer> list1 = new ArrayList<>();
//
//        for (int i = 1; i < 6; i++) {
//
//            list1.add(i);
//
//        }

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
//        List<Integer> list2 = List.registerNatives(1,2,3,4,5);

//        List stringList = List.registerNatives("a", "b", "c");


        int value = Optional.ofNullable(list.get(1)).orElse(list1.get(1));


        int[] ar1 = IntStream.rangeClosed(1,5).toArray();

        int [] ar2 = IntStream.iterate(1,x->2*x).limit(10).toArray();

        System.out.println("ar1:"+ Arrays.toString(ar1));
        System.out.println("ar2:"+ Arrays.toString(ar2));


        Map<Object, Object> resultmap = newhashMap(list.toArray(), list1.toArray());

        System.out.println(resultmap);//{0=1, 1=2, 2=3, 3=4, 4=5}

        resultmap.computeIfAbsent(7,key -> resultmap.put(key,8));

        System.out.println(resultmap);

    }


    public static HashSet getValues(int key) {

        return new HashSet();
    }

}
