package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        Date currentDate = new Date(date);
        Date startDate = new Date(date);

        System.out.println(startDate);

        currentDate.setDate(1);
        currentDate.setMonth(0);

        long time = currentDate.getTime() - startDate.getTime();
        long days = time / 24 / 60 / 60 / 1000 + 1;
        System.out.println(days);
        return days % 2 == 0 ? false: true;

//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
//        Date currentTime = dateFormat.parse(date);
//        long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
//        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
//        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
//        System.out.println("Days from start of year: " + dayCount);

    }
}
