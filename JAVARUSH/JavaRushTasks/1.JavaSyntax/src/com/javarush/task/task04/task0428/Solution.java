package com.javarush.task.task04.task0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Положительное число
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int[] arr = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0, a = 0, mem = 0;

        while(cnt < 3) {
            a = Integer.parseInt(reader.readLine());   // тут просто считывем сколько нужно раз в цикле, без повтора строк
            arr[cnt] = a;                              // заполняем массив
            if (a > 0)
                mem++;
            cnt++;
        }
/*
        for (int i: arr)
            System.out.print(i + " ");     // тут тонкий моумент - хотел сделать arr[i] но так не надо
*/
        System.out.println(mem);
    }
}
