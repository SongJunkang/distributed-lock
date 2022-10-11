package com.atguigu.service;

import com.atguigu.mapper.StockMapper;
import com.atguigu.pojo.Stock;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author joakims
 * @create 2022-09-24-21:45
 **/

@Service
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS )
//proxyMode的默认值是No，表示非不生效。

public class StockService {


    //service默认的是单例的。

//    private Stock stock  = new Stock();

    @Autowired
    private StockMapper stockMapper;

    private StringRedisTemplate template;

    private RedisTemplate redisTemplate;
    //这2个序列化器不一样。

    private ReentrantLock  lock = new ReentrantLock ();


//    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public  void deduct(){


        lock.lock();
        try {

            /**
             * 1.查询库存。
             * 2.判断库存是否充足，
             * 3，更新库存到数据库。
             */
//            this.stockMapper.updateStock(1);
            Stock stock= this.stockMapper.selectOne(new QueryWrapper<Stock>().eq("product_code","1001"));

            if (stock != null && stock .getCount() > 0) {
                stock.setCount(stock.getCount() -1);

                this.stockMapper.updateById(stock);
            }
            System.out.println("库存余量："  + stock.getCount());
        } finally {

            lock.unlock();
        }

    }

    public  void deduct1(){

        Stock stock = stockMapper.getStockById(1);

        Integer version = stock.getVersion();

        if (stockMapper.update(stock, new UpdateWrapper<Stock>().eq("id", stock.getId()).eq("version", version)) == 0) {

            //如果更新失败，则进行重试，
            this.deduct1();
        }


    }

    public Stock getStock() {
        Stock stock = this.stockMapper.selectOne(new QueryWrapper<Stock>().eq("id","1"));
        Stock stock2 = stockMapper.selectOne(new QueryWrapper<Stock>().eq("id", "1"));

        Stock stock1 = stockMapper.getStockById(1);
        return stock1;

    }

    public Stock getStockById(Integer id) {



        Stock stock = stockMapper.getStockById(id);

        Integer version = stock.getVersion();

        if (stockMapper.update(stock, new UpdateWrapper<Stock>().eq("id", stock.getId()).eq("version", version)) == 0) {


        }



        return  stock;

    }
}
