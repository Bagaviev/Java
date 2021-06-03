package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
И еще один адаптер
*/
/*
public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;
        String[] strs;
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd M yyyy", Locale.ENGLISH);

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            fileScanner = new Scanner("filename");
            String str = fileScanner.nextLine();
            strs = str.split(" ");
            return new Person(strs[0], strs[1], strs[2], inputFormat.parse(strs[2]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {

            String str = fileScanner.nextLine();
            String[] split = str.split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
            Date date = calendar.getTime();
            Person person = new Person(split[1], split[2], split[0], date);
            return person;

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
