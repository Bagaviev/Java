package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


/* 
Загрузчик файлов
*/

public class Solution {
// https://javarush.ru/testdata/secretPasswords.txt
    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:\\Desktop_D\\РАЗНОЕ\\работа_развитие\\jaava\\test\\dir"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {      // круто
        URL url = new URL(urlString);
        assert (urlString.length() > 0);
        InputStream inputStream = url.openStream();

        String loadFilename = urlString.split("/")[urlString.split("/").length - 1];
//         String filename = Paths.get(url.getPath()).getFileName().toString(); // прекрасный способ, но не засчитывается
        Path loadPath = downloadDirectory.resolve(loadFilename);

        Path tempFile = Files.createTempFile(null, null);

        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.move(tempFile, loadPath, StandardCopyOption.REPLACE_EXISTING);

        inputStream.close();
        return loadPath;
    }
}
