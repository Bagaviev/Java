/*
package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = 0;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new ArrayList<>();

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        File fileFile = file.toFile();

        boolean nameCondition = fileFile.getName().contains(getPartOfName());
        boolean contentCondition = checkContent(content, partOfContent);
        boolean minCondition = fileFile.length() > getMinSize();
        boolean maxCondition = fileFile.length() < getMaxSize();

        if (nameCondition && contentCondition && minCondition && maxCondition) {      // важный момент! дефолтные значения найдут все, фильтры опциональны
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public static boolean checkContent(byte[] content, String partOfContent) {
        String fullMergedString = new String(content);
        return fullMergedString.contains(partOfContent);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
*/
package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // check if file name contains search string
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;

        // read file content
        byte[] content = Files.readAllBytes(file);

        //check size of file
        if ((maxSize > 0 && content.length > maxSize) || (minSize > 0 && content.length < minSize)) return FileVisitResult.CONTINUE;

        // check contents of file
        if (partOfContent != null && !partOfContent.isEmpty()) {
            String contentString = new String(content);
            if (!contentString.contains(partOfContent)) return FileVisitResult.CONTINUE;
        }

        // if all checks are passed, add file to result list
        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}
