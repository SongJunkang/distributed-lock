package com.atguigu.demo;

/**
 * @author joakims
 * @create 2022-10-12-1:08
 **/


import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoo {


    Integer[] array1 = {1,2,3,4,5};

//    public Integer[] getArray1() {
//        return array1;
//    }

    //    Integer[] array2 = new Integer[] {1, 2, 3};
    Stream<Integer> stream1 = Stream.of(array1);

    public List<Integer> filterByStream(){

        return Arrays.stream(array1).filter(x -> x > 3).collect(Collectors.toList());

    }

    @Data
   public class Student{
        Integer Id;
        Integer Score;

    }

//   多条件组合排序 students.sort(Comparator.comparing(Student::getScore).thenComparing(Student::getName));
//Collections.sort(students,Comparator.comparing(Student::getScore).thenComparing(Student::getName));

    private List<Student> sortedByStreamSorted(List<Student> students) {
        return students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
    }

    private void calc(List<Student> students) {
        DoubleSummaryStatistics summaryStatistics =
                students.stream().mapToDouble(Student::getScore).summaryStatistics();
        System.out.println("平均分：" + summaryStatistics.getAverage());
        System.out.println("总分：" + summaryStatistics.getSum());
        System.out.println("最高分：" + summaryStatistics.getMax());
        System.out.println("最低分：" + summaryStatistics.getMin());
    }

    public static void main(String[] args) {

        StreamDemoo streamDemo = new StreamDemoo();
        List<Integer> result = streamDemo.filterByStream();

        System.out.println(result.toString());
    }
}

