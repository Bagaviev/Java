package util;

import java.util.Date;
import java.util.Random;

public class Timer {
    public static String estimateTime(Sortable sorting, int size) {
        int[] array = fill(size);
        Printer.print(array);

        Date start = new Date();
        sorting.sort(array);
        sorting.sort(array, 0, size - 1);
        sorting.sort(array, size - 1);
        Date stop = new Date();

        Printer.print(array);
        return "Estimated time: " + (stop.getTime() - start.getTime()) / 1000.0 + " sec";
    }

    private static int[] fill(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++)
            arr[i] = rand.nextInt(1000);

        return arr;
    }
}
