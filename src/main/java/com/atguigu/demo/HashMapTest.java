package com.atguigu.demo;

import com.atguigu.pojo.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapTest {


    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer, User> newsortHashMap = sortHashMap(users);
        System.out.println(newsortHashMap);
    }

        public static HashMap<Integer, User> sortHashMap (HashMap < Integer, User > map){
            // 首先拿到 map 的键值对集合
            Set<Map.Entry<Integer, User>> entrySet = map.entrySet();

            HashMap < Integer, User > map1 = (HashMap<Integer, User>) map.clone();
            System.out.println("克隆之后的map集合："+map1);

            Stream<Map.Entry<Integer, User>> stream = map1.entrySet().stream();

            System.out.println("克隆之后的mapStream集合："+map1);


            // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
            List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);

            System.out.println("map集合转为list："+list);


            // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
            list.sort((o1, o2) -> {
                //按照要求根据 User 的 age 的倒序进行排
                return o2.getValue().getAge() - o1.getValue().getAge();

            });
            //创建一个新的有序的 HashMap 子类的集合
            LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
            //将 List 中的数据存储在 LinkedHashMap 中
            for (Map.Entry<Integer, User> entry : list) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }

            return linkedHashMap;
        }
    }
