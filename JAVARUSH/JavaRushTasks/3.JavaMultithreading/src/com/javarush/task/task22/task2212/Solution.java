package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean isValid = false;

        if (telNumber.matches("^\\+[0-9]{12}"))   // mine
            isValid = true;

        return isValid;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38050123456"));
        System.out.println(checkTelNumber("+3805012345670"));
    }
}
