package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
*/

/*
0 1
1 1
2 2
3 6
4 24
5 120
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if (n >= 100 && n < 0)
            return 0;
        else if (n == 0 || n == 1)
            return 1;
        else
            return n *= factorial(n - 1);    // fact(3) = 3 * fact(2 * fact(1))
    }
}
