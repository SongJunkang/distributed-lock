package com.atguigu.myDateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ThreadLocalDateFormat {


    //由于 SimpleDateFormat 是非线程安全的，当多线程同时调用 formatDate 函数时， 会导致返回结果与预期不一致
    private static final ThreadLocal<DateFormat> LOCAL_DATE_FORMAT  = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {

            return new SimpleDateFormat("yyyy-MM-dd");

        }

    };
    public static String formatDate(Date date){

            return LOCAL_DATE_FORMAT.get().format(date);


    }

    public static void main(String[] args) {

        Date d = new Date();

        String result = formatDate(d);

        System.out.println("当前日期转换："+ result);
        LOCAL_DATE_FORMAT.remove();



    }
}
