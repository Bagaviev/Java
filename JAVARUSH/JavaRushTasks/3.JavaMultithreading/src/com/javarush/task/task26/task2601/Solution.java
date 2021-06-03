package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {13, 8, 15, 5, 17};
        System.out.println(calculateMedian(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static Integer calculateMedian(Integer[] array) {
        Arrays.sort(array);
        Integer median;
        if (array.length % 2 == 0)
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else
            median = array[array.length / 2];
        return median;
    }

    public static Integer[] sort(Integer[] array) {
        Integer median = calculateMedian(array);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(median - o1) > Math.abs(median - o2))  // тут момент тонкий:
                    return 1;
                else if (Math.abs(median - o1) < Math.abs(median - o2))
                    return -1;
                else
                    return 0;
            }
        };

        Arrays.sort(array, comp);
        return array;
    }
}
