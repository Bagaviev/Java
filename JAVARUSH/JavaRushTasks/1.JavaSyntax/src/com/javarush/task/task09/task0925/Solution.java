package com.javarush.task.task09.task0925;

/* 
Статики не на своем месте
*/

public class Solution {
    public static int A = 5;
    public static int B = 2 * A;
    public int C = A * B;
    public static int D = A * B;

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Solution.A);
          solution.A = 5;
//        solution.A = 6;
//        System.out.println(Solution.A);
           Solution.D = 5;
    }

    public int getA() {return A;}

}
