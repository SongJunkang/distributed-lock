package com.atguigu.mapper;

import com.atguigu.pojo.Stock;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface StockMapper extends BaseMapper<Stock>{

    @Update("update db_stock set count = count - ${count} where product_code =1001 and count >=${count} ;")
    int updateStock(@Param("count") Integer count);


    @Select("select * from db_stock where id = ${id}")
    Stock getStockById(Integer id );
}
