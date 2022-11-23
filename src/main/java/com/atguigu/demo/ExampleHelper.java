package com.atguigu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ExampleHelper {

    private static final int [] CONST_VALUES = {2,1,3};

    public static int[] getValues(){

        return CONST_VALUES.clone();

    }

    public static void main(String[] args) {

        int[] values = ExampleHelper.getValues();


        for (int value :
                values) {
            System.out.println(value);
        }

        Arrays.sort(values);

        List<Integer> listValues = new ArrayList<>();
        listValues.add(1);
        listValues.add(2);
        listValues.add(4);


//        listValues.stream().map()


        //这里是foreach的另一种不太好用的形式。

        Iterator<Integer> iterator = listValues.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }



        System.out.println(Arrays.toString(values));

        values[1] = 20;

        System.out.println(Arrays.toString(values));

        int[] values1 = ExampleHelper.getValues();

        System.out.println(Arrays.toString(values1));
    }

}
