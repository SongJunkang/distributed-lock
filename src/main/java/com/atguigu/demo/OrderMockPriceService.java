//package com.atguigu.demo;
//
//import com.sun.istack.internal.NotNull;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.Set;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
///**
// * @author joakims
// * @create 2022-10-13-0:17
// **/
//
//@Service
//public class OrderMockPriceService {
//
//
//
//    class Mockconfig{
//
////        public Integer getMainPrice(List<Integer>  list){
////
////           list.stream().sorted().collect(Collectors.toList());
////           return list.get(0);
////       }
//
//        public Set<String> getWhiteSet() {
//
//            return getWhiteSet();
//        }
//
//
//        public Integer getMainPrice(  ) {
//            List<Integer> list = null;
//            list.stream().sorted().collect(Collectors.toList());
//            return list.get(0);
//        }
//    }
//    @Resource
//    private Mockconfig mockconfig;
//
//    public Integer getMainMockPrice(String userId, Integer orderPrice){
//            return getMockPrice(userId,orderPrice,mockconfig::getMainPrice);
//    }
////    Object is not a functional interface
//
//    private Integer getMockPrice(String userId, Integer orderPrice, Supplier<Integer> supplier) {
//        Set<String> whiteSet =mockconfig.getWhiteSet();
//
//
//        if (Objects.nonNull(whiteSet) && whiteSet.contains(userId)){
//            return orderPrice;
//        }
//
//        return Optional.ofNullable(supplier.get()).orElse(orderPrice);
//    }
//
//}
