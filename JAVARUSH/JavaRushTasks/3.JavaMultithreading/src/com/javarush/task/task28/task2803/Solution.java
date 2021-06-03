package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/

public class Solution {
    public synchronized static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public synchronized static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public synchronized static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n + 1);
    }

    public synchronized static void main(String[] args) {
    }
}
