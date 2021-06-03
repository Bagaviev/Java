package com.javarush.task.task18.task1825;

import javax.swing.*;
import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\Lion.txt.part1
//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\Lion.txt.part2
//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\Lion.txt.part3
//D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\Lion.txt

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, byte[]> map = new TreeMap<Integer, byte[]>();
        String str;
        String name = null;
        byte[] buffer;
        int position;

        while (!(str = reader.readLine()).equals("end")) {
            FileInputStream fileInputStream = new FileInputStream(str);
            buffer = new byte[fileInputStream.available()];

            position = Integer.parseInt(str.split("\\.")[2].split("part")[1]);
            name = str.split("\\.")[0];

            fileInputStream.read(buffer);
            map.put(position, buffer);

//            System.out.println(map);
            fileInputStream.close();
        }

        for (Map.Entry<Integer, byte[]> pair : map.entrySet()) {
            buffer = pair.getValue();
            FileOutputStream fileOutputStream = new FileOutputStream(name + ".txt", true);
            fileOutputStream.write(buffer);
//            fileOutputStream.write(System.lineSeparator().getBytes());
            fileOutputStream.close();
        }

    reader.close();
    }
}
