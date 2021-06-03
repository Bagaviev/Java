package com.javarush.task.task30.task3001;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }
/*
    6 -> 2
    6%2 = 3 (0)
        3%2 = 1 (1)
            1%2 = 0 (1)
*/
    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        BigInteger bi = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String ans = bi.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, ans);
    }
}




/*
    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {  // own
        int digit = Integer.parseInt(number.getDigit());
        int system = expectedNumberSystem.getNumberSystemIntValue();
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            stringBuilder.append(digit % system);
            digit /= system;
            if (digit == 0)
                break;
        }

        String result = stringBuilder.reverse().toString();
        return new Number(expectedNumberSystem, result);
    }
 */