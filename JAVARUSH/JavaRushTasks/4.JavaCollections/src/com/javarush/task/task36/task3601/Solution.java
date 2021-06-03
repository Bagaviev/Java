package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
MVC - простая версия
*/

// ArrayList<String> places = new ArrayList<String>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata")); list init иниц список

public class Solution {
    public static void main(String[] args) {
        View view = new View();

        view.fireShowDataEvent();
    }
}
