package com.atguigu.demo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestComputeIfAbsent {

        static HashMap<String, Set<String>> hashMap = new HashMap<>();

        public static void main(String[] args) {
            Set<String> set = new HashSet<>();
            set.add("zhangSan");
            hashMap.put("china", set);
            // after JDK1.8
            hashMap.computeIfAbsent("china", key -> getValues(key)).add("liSi");

            if(!CollectionUtils.isEmpty(hashMap)){

                System.out.println(hashMap);

                hashMap.computeIfAbsent("america", key -> getValues(key)).add("kobe");
                System.out.println(hashMap);

            }

        }

        @Contract(value = "_ -> new", pure = true)
        public static @NotNull HashSet getValues(String key) {
            return new HashSet();
        }

        

}
