package com.atguigu.demo;

import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarDemo {



    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_MONTH,-5);

        System.out.println(calendar.getTime());

        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

        System.out.println(yesterday);


    }
}
