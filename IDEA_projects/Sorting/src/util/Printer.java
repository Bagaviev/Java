package util;

import java.util.Arrays;

public class Printer {
    public static void print(int[] array) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, 7)) + "...");
    }

    // todo: radix sort, counting sort, timsort
}
