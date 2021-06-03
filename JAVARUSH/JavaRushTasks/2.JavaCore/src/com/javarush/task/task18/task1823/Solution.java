package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\resultDecr.txt
// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\java_samples\file_read\resultEncr.txt

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String str;

    public static void main(String[] args) throws IOException, InterruptedException {
        while (!(str = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(str);
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String filename;

        public ReadThread(String fileName) {
            this.filename = fileName;
            start();
        }

        @Override
        public void run() {
            FileInputStream inStream = null;

            try {
                inStream = new FileInputStream(filename);

                int[] arr = new int[255];
                ArrayList<Integer> printList = new ArrayList<>();

                while(inStream.available() > 0) {
                    int data = inStream.read();
                    arr[data]++;
                    printList.add(data);
                }

                int repeats = 0;
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] > repeats)
                        repeats = arr[i];
                }

                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] == repeats)
                        resultMap.put(filename, i);    // момент важный! пишем номер индекса а не элемент по индексу!
                }

                inStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(resultMap.toString());
        }
    }
}
