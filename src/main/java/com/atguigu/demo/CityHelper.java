package com.atguigu.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

/**
 * 书籍上的例子，调试编程，2022年10月13日。
 * 从CSV中读取城市的样子
 */

@Slf4j
public class CityHelper {

    public static Collection<City> readCites(String filename){

        try (
            FileInputStream stream  = new FileInputStream(filename);

            InputStreamReader reader = new InputStreamReader(stream,"GBK");

            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())){


            Set<City> citySet = new HashSet<>(1024);

            Iterator<CSVRecord> iterator = parser.iterator();

            while (iterator.hasNext())
            {
                citySet.add(parserCity(iterator.next()));
            }
            return citySet;


//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
        } catch (IOException e) {


            log.warn("读取所有城市异常{}",e);

        }

        return Collections.emptyList();


    }

    private static City parserCity(CSVRecord record) {

        City city = new City();

        city.setCode(record.get(0));

        city.setName(record.get(1));

        return city;



    }


    @Data
    public static class City{
        /*
          城市编码
         */
        private String code;

        /*
            城市名称。
         */

        private String name;


        /**
         * 判断相等。
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {

            if(this == obj)
                return true;

            if (Objects.isNull(obj))
                return false;

            if (obj.getClass() != this.getClass())
                return false;

            return Objects.equals(this.code,((City) obj).code);
        }

        @Override
        public int hashCode(){

            return Objects.hashCode(this.code);
        }


    }


    public static void main(String[] args) {

        Collection<City> cities = readCites("city.csv");

        System.out.println(cities);



    }
}
