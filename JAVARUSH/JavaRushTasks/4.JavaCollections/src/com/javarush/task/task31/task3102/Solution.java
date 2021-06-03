package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.BlockingDeque;

/* 
Находим все файлы
*/

// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\test\dir
// можно было бы пилить на стрим апи, но решил не выебываться

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> fileQueue = new PriorityQueue<>();
        List<String> fileList = new ArrayList<>();
        File file = new File(root);

        fileQueue.addAll(Arrays.asList(file.listFiles()));

        while (!fileQueue.isEmpty()) {
            File item = fileQueue.poll();
            if (item.isDirectory()) {
                for (File subFile : item.listFiles())
                    fileQueue.offer(subFile);
            } else
                fileList.add(item.getPath());
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
//        for (String foundFiles : getFileTree("D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\test\\dir")) {
//            System.out.println(foundFiles);
//        }
    }
}
