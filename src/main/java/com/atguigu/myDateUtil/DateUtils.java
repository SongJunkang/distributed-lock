package com.atguigu.myDateUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


@Slf4j
public class DateUtils {

    public static Date formatString(String date){
        if (!StringUtils.hasLength(date)) {

            return null;
        }

        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat(Constants.SIMPLE_DATA_FORMART);
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            log.warn("formatString for {} exception. ",date,e);
            //formatString for Sat Oct 08 14:09:40 CST 2022 exception.
            throw new RuntimeException(e);
        }

    }

    public static String formatDate(Date date){
//        if (date == null)
        if (Objects.isNull(date))
        {

            return null;
        }

        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat(Constants.SIMPLE_DATA_FORMART);
        return simpleDateFormat.format(date);

    }

}
