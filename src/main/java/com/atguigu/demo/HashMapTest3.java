package com.atguigu.demo;

import com.atguigu.pojo.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapTest3 {


    public static void main(String[] args) {

        HashMap<Integer, User> users = new HashMap<>();

        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));

        System.out.println(users);

        List<Map.Entry<Integer, User>> list = new ArrayList<>(users.entrySet());


        list.sort((o1, o2) -> {
            //按照要求根据 User 的 age 的倒序进行排
            return o2.getValue().getAge() - o1.getValue().getAge();

        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
        //将 List 中的数据存储在 LinkedHashMap 中
        for (Map.Entry<Integer, User> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(linkedHashMap);

        Comparator<Map.Entry<Integer, User>> nameComparator = Comparator.comparing(Map.Entry::getValue, (s1, s2) -> s2.getAge().compareTo(s2.getAge()));

        Stream<Map.Entry<Integer, User>> entryStream = list.stream().sorted(nameComparator);


//        Stream<Map.Entry<Integer, User>> entryStream = list.stream().sorted(
//                Comparator.comparing(((Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) -> {
//
//                     return o2.getValue().getAge() - o1.getValue().getAge();
//
//                }))) ;

//
//
//
//        System.out.println("排序过后："+ Arrays.toString(entryStream.toArray()));


    }



}
