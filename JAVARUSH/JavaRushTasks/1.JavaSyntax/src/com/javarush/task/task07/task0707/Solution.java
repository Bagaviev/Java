package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {

        ArrayList<String> stringList = new ArrayList<String>(4);

        for (int i = 0; i < 5 ; i++) {
            stringList.add("some_str" + i);
        }

        System.out.println(stringList.size());

       for (String i : stringList) {
           System.out.println(i + " ");
       }
    }
}
