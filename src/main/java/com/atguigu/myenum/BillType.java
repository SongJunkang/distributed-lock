package com.atguigu.myenum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

import java.util.Arrays;


@Getter
public enum BillType {

    TRANS_BILL(1,"运单"),TASK_BILL(2,"运输任务单"),MB_BILL(3,"纯线上订单");
    @EnumValue
    int code;
    String msg;


    BillType(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static BillType instanceByCode( int code){
        return Arrays.stream(values()).filter((BillType a )->a.getCode() == code)
                .findFirst().orElseThrow(() ->new IllegalArgumentException("不支持的账单类型代码 ：" + code));
    }

}
