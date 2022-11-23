package com.atguigu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.mapper.StockMapper;
import com.atguigu.myDateUtil.DateUtils;
import com.atguigu.myenum.BillType;
import com.atguigu.pojo.Stock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@Slf4j
class DistributedLockApplicationTests {

//    @Test
//    void contextLoads() {
//
//
//    }

    @Autowired
    public StockMapper stockMapper;

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


    @Test
    public void testFastJsonDemo(){

        Stock stock1 = stockMapper.getStockById(1);

        System.out.println(stock1);

        String json = JSONObject.toJSONString(stock1);

        log.info("json数据格式为：{}",json);
        System.out.println(json);

        Stock stock = JSONObject.parseObject(json, Stock.class);
        log.info("反序列化为 {}",stock);
        System.out.println(stock);



    }

}
