package com.atguigu.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.ibatis.annotations.Select;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Lang3Demo {

   public void testStringU(){
        boolean result = StringUtils.isBlank("");
        boolean resultcontains = StringUtils.contains("你是哪里人", "你");

        log.info("String的结果：{}，contains的结果：{}",result,resultcontains);


    }

    public  Pair<Point,Double> getNearestPointAndDistance(Point point,Point [] points){

        if (points == null) {
                return null;

        }

        Point nearestPoint  = points[0];
        double nearestDistance = getDistance(point,nearestPoint);

        for (int i = 1; i <points.length; i++) {

            double distance = getDistance(point, points[i]);

            if (nearestDistance >  distance)
            {
                nearestDistance = distance;

                nearestPoint = points[i];

            }
        }

        return Pair.of(nearestPoint,nearestDistance);
    }

    private double getDistance(Point p1, Point p2) {

       return p1.distance(p2);

//       return Math.sqrt(Math.abs((p1.getX() - p2.getX())* (p1.getX() - p2.getX())+(p1.getY() - p2.getY())* (p1.getY() - p2.getY())));

    }

    public static void main(String[] args) {

        System.out.println(StringUtils.isNotBlank("1"));

        Lang3Demo lang3Demo = new Lang3Demo();

        boolean result = StringUtils.isBlank("");
        boolean resultcontains = StringUtils.contains("你是哪里人", "你");

        log.info("String的结果：{}，contains的结果：{}",result,resultcontains);


        ImmutablePair<Object,Object> immutablePair = new ImmutablePair<>(1,2);
        ImmutablePair<Object,Object> immutablePair2 = ImmutablePair.of(1,2);
//        ImmutableTriple <> immutableTriple = ImmutableTriple.of();

        Integer left = (Integer) immutablePair.getLeft();

        System.out.println(left);

        List list = new ArrayList<>();


        Point a = new Point(2,4);
        Point b = new Point(12,4);
        Point c = new Point(2,9);
        Point d = new Point(6,20);
        Point e = new Point(4,3);



        Point [] points = {b,c,d,e };

        Pair<Point, Double> resultdistance = lang3Demo.getNearestPointAndDistance(a, points);

        System.out.println("最近的点是：（"+ resultdistance.getLeft().getX() +","+ resultdistance.getLeft().getY() +")");
        System.out.println("最近的距离是："+ resultdistance.getRight());





    }
}
