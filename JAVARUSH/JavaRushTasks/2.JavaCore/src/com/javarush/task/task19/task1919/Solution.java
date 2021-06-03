package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
//    static String path = "D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\zp.txt";

    public static void main(String[] args) throws IOException {
        if(args.length == 0)
            return;

        String path = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Map<String, List<Double>> tree = new TreeMap<String, List<Double>>();
        List<Double> list;

        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.split(" ")[0];
            Double amount = Double.parseDouble(line.split(" ")[1]);

            if (tree.get(name) == null) {
                list = new ArrayList<Double>();
                list.add(amount);
                tree.put(name, list);
            } else {
                tree.get(name).add(amount);
            }
        }
        reader.close();

        for (Map.Entry<String, List<Double>> pair : tree.entrySet()) {
            String key = pair.getKey();
            List<Double> listTmp = pair.getValue();
//            System.out.print(key + " " + list.toString() + " " + list.stream().mapToDouble(Double::doubleValue).sum() + "\n");
            System.out.print(key + " " + listTmp.stream().mapToDouble(Double::doubleValue).sum() + "\n");
        }
    }
}
