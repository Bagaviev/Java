package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toMap;

/* 
Самые частые байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

//        String filename = "D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt";

        FileInputStream inStream = new FileInputStream(filename);
        int[] arr = new int[255];
        ArrayList<Integer> printList = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

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
                resultList.add(i);    // момент важный! пишем номер индекса а не элемент по индексу!
        }

//        Collections.sort(printList, Collections.reverseOrder());
//        System.out.println(printList);

//        System.out.println(Arrays.toString(arr));

        for (Integer num: resultList) {
            System.out.print(num + " ");
        }

        reader.close();
        inStream.close();
    }
}
