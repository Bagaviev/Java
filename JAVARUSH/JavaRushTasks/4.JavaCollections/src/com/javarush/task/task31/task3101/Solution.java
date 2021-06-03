package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/

// тут вот дроч немного

// File
// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\test\dir
// D:\Desktop_D\РАЗНОЕ\работа_развитие\jaava\test\rrfr.txt

public class Solution {
    public List<File> walker(List<File> listFiles, File file) {        // уря работает своя рекурсия! Без сторонних либ
        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                walker(listFiles, files);
            } else {
                if (isLessOrEqual50b(files))
                    listFiles.add(files);
            }
        }
        return listFiles;
    }

    public boolean isLessOrEqual50b(File file) {
        return file.length() <= 50;
    }

    public void combineFileContents(List<File> list, File result) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {
            for (File file: list) {
                String str;
                BufferedReader reader = new BufferedReader(new FileReader(file));

                while ((str = reader.readLine()) != null) {
                    writer.write(str);
                    writer.newLine();
                    writer.flush();
                }
            }
            System.out.println("Done");
        }
    }

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        List<File> listFiles = new ArrayList<>();

        File path = new File(args[0]);                      // dir to scan
        File resultFileAbsolutePath = new File(args[1]);    // output file with dir scanned files collected

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            String tmp = resultFileAbsolutePath.getParent();    // путь до файла, без имени файла
            FileUtils.renameFile(resultFileAbsolutePath, new File(tmp + "\\allFilesContent.txt"));
        }

        sol.walker(listFiles, path);
        Collections.sort(listFiles, Comparator.comparing(File::getName)); // вау тут сначала был анонимный класс, затем лямбда, а потом идея предложила это


        for (File file : listFiles) {
            System.out.println(file);
        }

        sol.combineFileContents(listFiles, resultFileAbsolutePath);
    }
}

// кароче по смыслу работает, с валиком ебаться не охота

/*
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/

/*
public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                for (byte[] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
                }
            }
            return super.visitFile(path, basicFileAttributes);
        }
    }
}
*/