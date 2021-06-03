package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> strings = new ArrayList<Integer>();
        ArrayList<Integer> triples = new ArrayList<Integer>();
        ArrayList<Integer> doubles = new ArrayList<Integer>();
        ArrayList<Integer> others = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numReads = 20;

        for (int i = 0; i < numReads; i++) {
            strings.add(Integer.parseInt(reader.readLine()));
        }

        for (int j = 0; j < strings.size(); j++) {
            if (strings.get(j) % 3 == 0 & strings.get(j) % 2 == 0) {
                triples.add(strings.get(j));
                doubles.add(strings.get(j));
            }
            else if (strings.get(j) % 3 == 0)
                triples.add(strings.get(j));
            else if ((strings.get(j) % 2 == 0))
                doubles.add(strings.get(j));
            else
                others.add(strings.get(j));
        }

        printList(triples);
        printList(doubles);
        printList(others);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
