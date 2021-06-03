package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/
/*
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    //D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test.txt
    //D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\java_samples\\file_read\\test2.txt

    public static void fileReader(String path, List<String> list) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.joinData();
//        System.out.println(allLines);
    }

    public void joinData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allLinesPath = reader.readLine();
        String forRemoveLinesPath = reader.readLine();

        fileReader(allLinesPath, allLines);
        fileReader(forRemoveLinesPath, forRemoveLines);

        List<String> allLinesCpy = new ArrayList<>(allLines);
        List<String> forRemoveLinesCpy = new ArrayList<>(forRemoveLines);

        forRemoveLinesCpy.removeAll(allLinesCpy);

        if(forRemoveLinesCpy.size() == 0) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
//            System.out.println(allLines);
            throw new CorruptedDataException();
        }
    }
}
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = null;
        String fileName2 = null;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();
            BufferedReader fReader1 = new BufferedReader(new FileReader(fileName1));
            String input;
            while ((input = fReader1.readLine()) != null)
                allLines.add(input);
            fReader1.close();
            BufferedReader fReader2 = new BufferedReader(new FileReader(fileName2));
            while ((input = fReader2.readLine()) != null)
                forRemoveLines.add(input);
            fReader2.close();
            new Solution().joinData();
        } catch (Exception ignore) {
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}