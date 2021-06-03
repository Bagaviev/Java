package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        Date now1 = new Date();

        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        Date now2 = new Date();
        long diff1 = now2.getTime() - now1.getTime();
        //System.out.println(diff1);

        Date now3 = new Date();
        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);

        Date now4 = new Date();
        long diff2 = now4.getTime() - now3.getTime();
        //System.out.println(diff2);
    }

    public static void insert10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }

    public static void get10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
    }

    public static void set10000(List list) {
        for (int i = 0; i < 10000; i++) {
            list.set(i, i);
        }
    }

    public static void remove10000(List list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
    }
}
