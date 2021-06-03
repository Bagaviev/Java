package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        if(args.length == 0)
//            return;

//        String path = "D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\zp.txt";
        String path = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<String, Double> tree = new TreeMap<String, Double>();

        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.split(" ")[0];
            Double amount = Double.parseDouble(line.split(" ")[1]);

            if (tree.get(name) == null) {
                tree.put(name, amount);
            } else {
                Double tmpAmount = tree.get(name);
                tree.put(name, tmpAmount + amount);
            }
        }
        reader.close();

//        for (Map.Entry<String, Double> pair : tree.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }

        Double max = Collections.max(tree.values());

        for (Map.Entry<String, Double> entry : tree.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
