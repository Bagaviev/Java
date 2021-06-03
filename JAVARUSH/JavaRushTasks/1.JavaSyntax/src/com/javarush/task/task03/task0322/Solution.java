package com.javarush.task.task03.task0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Большая и чистая
*/

public class Solution {
//    String greeting;

    public static void main(String[] args) throws Exception {
//        Solution solution = new Solution();
//        solution.greeting = "Введите 3 имени последовательно через Enter:";
//        System.out.println(solution.greeting);

        BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();

        System.out.printf("%s + %s + %s = Чистая любовь, да-да!", name1, name2, name3);
    }
}
//Вася + Ева + Анжелика = Чистая любовь, да-да!