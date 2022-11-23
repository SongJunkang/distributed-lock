package com.atguigu.demo;

import com.atguigu.pojo.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapTest2 {


    public static void main(String[] args) {

        HashMap<Integer, User> users = new HashMap<>();

        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);

        List<Map.Entry<Integer, User>> list = new ArrayList<>(users.entrySet());
//{1=User(name=张三, age=25), 2=User(name=王五, age=28), 3=User(name=李四, age=22)}
//[1=User(name=张三, age=25), 2=User(name=王五, age=28), 3=User(name=李四, age=22)]
        System.out.println(list);


        List<Map.Entry<Integer, User>> list1 = list.stream().sorted(Map.Entry.comparingByValue(Comparator.
                        comparing(User::getAge).reversed())).collect(Collectors.toList());

         list.stream().sorted(Comparator.comparing(Map.Entry::getValue, (s1, s2) -> s2.getAge().compareTo(s2.getAge())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("list1:"+list1);


        LinkedHashMap<Integer, User> linkedHashMap2 = new LinkedHashMap<Integer, User>();
        //将 List 中的数据存储在 LinkedHashMap 中
        for (Map.Entry<Integer, User> entry : list1) {
            linkedHashMap2.put(entry.getKey(), entry.getValue());
        }

        System.out.println("LinkedHashMap:" + linkedHashMap2);



//        Map<Integer, User> userMap2 = entrySet.stream().collect(Collectors.toMap(User::getAge, Function.identity()));

//        return accounts.stream().collect(Collectors.toMap(Account::getUsername, Function.identity(), (key1, key2) -> key2, LinkedHashMap::new));


//         Map<Integer,User> userMap2 =list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        //Non-static method cannot be referenced from a static context
        //报错：无法从静态上下文引用非静态方法
    }

//        public Map<String,User> getNameAccountMap(List<Map.Entry<Integer, User>> list) {
//            return list.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (key1, key2) -> key2, LinkedHashMap::new));
//
//            return list.stream().collect(Collectors.toMap(Map::keySet, account -> account));
//        }




//        Stream<Map.Entry<Integer, User>> mapToStream = users.entrySet().stream();

//        mapToStream.collect(Collectors.toMap(User::getAge,User->User));
//        ArrayList list = new ArrayList<>((Collection) users);
//
//        list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());


//        System.out.println(list);

    }



