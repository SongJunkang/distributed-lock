package com.atguigu.demo;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@Getter
public enum TestEnum {

    DELFERAT(0,"未知") ,
    MALE(1,"男生") ,
    FEMALE (2,"女性");


    @EnumValue
    private  int id;
    private  String msg;
    TestEnum(int id, String msg) {

        this.id = id;
        this.msg = msg;
    }

    public static TestEnum instanceById(int code){

        return Arrays.stream(values()).filter(a ->a.getId() == code).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("不支持的类型方式： " +code));
    }


    public static void main(String[] args) {
        int code = 1;

        TestEnum[] values = TestEnum.values();

        for (TestEnum value:
             values) {
            System.out.println(value + "--" +value.getId()+"--" +value.getMsg());
            System.out.println("===============================");
        }

        System.out.println(Arrays.toString(values));
        System.out.println(values[0]);

        TestEnum result = instanceById(code);

        log.info(String.valueOf(result));


//        System.out.println(result);
//        System.out.println(result.getMsg());




    }
}
