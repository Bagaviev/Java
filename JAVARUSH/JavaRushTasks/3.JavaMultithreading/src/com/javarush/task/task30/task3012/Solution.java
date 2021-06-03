package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

// https://gigabaza.ru/doc/55220.html

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder sB = new StringBuilder(number + " =");
        for (int i = 0; i < 8; i++) {
            if (number%3 == 1) {
                sB.append(" + ").append(array[i]);
            } else if (number%3 == 2) {
                sB.append(" - ").append(array[i]);
                number++;
            }
            number = number/3;
        }
        System.out.println(sB);
    }
}

/*
public void createExpression(int number) {
        int i = 0;
        StringBuilder result = new StringBuilder(number + " =");
        while (number > 0){
            int a = number / 3;
            int b = number % 3;
            if (b == 2){
                result = result.append( " - " + String.valueOf((int) Math.pow(3, i)));
                number = a + 1;
            } else if (b == 1){
                result = result.append( " + " + String.valueOf((int) Math.pow(3, i)));
                number = a;
            } else if (b == 0){
                number = a;
            }
            i++;
        }
        System.out.println(result);
    }
 */

/*
package com.javarush.task.task30.task3012;

/*
Получи заданное число
*/

/*

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        String[] allowedNumbers = {"1", "3", "9", "27", "81", "243", "729", "2187"};
        StringBuilder sb = new StringBuilder(number + " = ");
        String inTernarySymmetric = convertToTernarySymmetric(number);
        for (int i = 0; i < inTernarySymmetric.length(); i++) {
            if (inTernarySymmetric.charAt(i) != '0') {
                sb.append(inTernarySymmetric.charAt(i));
                sb.append(" ");
                sb.append(allowedNumbers[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private String convertToTernarySymmetric(int number) {
        StringBuilder sb = new StringBuilder();
        while (number >= 2) {
            if (number % 3 == 0) {
                sb.append("0");
                number /= 3;
            } else if (number % 3 == 1) {
                sb.append("+");
                number /= 3;
            } else if (number % 3 == 2) {
                sb.append("-");
                number = (number / 3) + 1;
            }
        }
        if (number == 1) {
            sb.append("+");
        }
        return sb.toString();
    }
}
 */