package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии  (факторизация)
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        factorize(42);      // 2, 3, 7
            Solution sol = new Solution();
            sol.recurse(42);
//        Date start = new Date();
//        testPrime();
//        Date stop = new Date();
//        System.out.println("Seconds: " + (stop.getTime() - start.getTime()) / 1000.0);
    }

    public void recurse(int n) {            // непонятно скатал
        if (n <= 1) return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }

    public static void factorize(int n) {     // static remove, main remove, recursive do
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

    /*
     for (int n = 2; n <= i; n++) {
        if (i % n == 0) {
            list.add(n);
            i /= n;
        }
    }
     */
    }

    /*
    public static boolean isPrime(int n) {
        int i = 2;
        if (n < 2)
            return false;
        else if (n == 2)
            return true;

        while (i <= Math.sqrt(n)) {         // могло бы быть до n - 1, но с корнем быстрее в 100 раз где-то
            if (n % i == 0)
                return false;
            i++;
        }

        return true;
    }

    public static void testPrime() {
        for (int i = 0; i < 20; i++) {
//            isPrime(i);
            System.out.println(i + " " + isPrime(i));
        }
    }

*/
}
