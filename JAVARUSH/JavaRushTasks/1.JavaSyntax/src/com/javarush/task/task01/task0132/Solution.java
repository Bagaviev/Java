package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {

          char[] ch = ("" + number).toCharArray();
          int dig_sum = 0;

          for(int i = 0; i < ch.length; i++) {
              dig_sum += Character.getNumericValue(ch[i]);
          }
        return dig_sum;
    }
}