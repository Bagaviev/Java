package com.javarush.task.task17.task1707;

/* 
МВФ
*/


public class Solution {
    public static void main(String[] args) throws InterruptedException {
        IMF fund = IMF.getFund();
        IMF anotherFund = IMF.getFund();
        System.out.println(fund == anotherFund);
    }
}
