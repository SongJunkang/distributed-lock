package com.atguigu;

import com.atguigu.myDateUtil.DateUtils;
import com.atguigu.myenum.BillType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class DistributedLockApplicationTests {

//    @Test
//    void contextLoads() {
//
//
//    }

    @Test
    public void testDateUtils(){

//        DateUtils dateUtils = new DateUtils();

        Calendar now = Calendar.getInstance();

        System.out.println("当前时间为:" +now.getTime());



//        Date date = DateUtils.formatString(String.valueOf(now.getTime()));
        //formatString for Sat Oct 08 14:09:40 CST 2022 exception.



        Date d = new Date();

        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateNowStr = sdf.format(d);

        System.out.println("格式化后的日期：" + dateNowStr);

        String s = DateUtils.formatDate(d);
        System.out.println("自己格式化：" + s);


//        Date date = DateUtils.formatString(String.valueOf(new Date()));
//
//
//        System.out.println(date);


    }

    @Test
    public void testBillType(){

        BillType billType = BillType.instanceByCode(2);


        System.out.println("代码为2的清单类型是：" + billType.getMsg() );
    }


}
