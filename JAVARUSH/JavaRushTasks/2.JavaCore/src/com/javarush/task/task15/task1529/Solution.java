package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
//        System.out.println("result1");
        System.out.println(result);
//        System.out.println("result2");
    }

    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String param;

        if ("helicopter".equals(str)) {
            result = new Helicopter();
        } else if ("plane".equals(str)) {
            param = reader.readLine();
            result = new Plane(Integer.parseInt(param));
        }
        reader.close();
    }
}
