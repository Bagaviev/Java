package com.javarush.task.task33.task3310;
import com.javarush.task.task33.task3310.strategy.*;

import java.util.*;

import static com.javarush.task.task33.task3310.Helper.*;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String str: strings) {
            set.add(shortener.getId(str));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long key: keys) {
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        printMessage(strategy.getClass().getSimpleName());
        Set<String> strs = new HashSet<>();

        while (elementsNumber > 0) {
            strs.add(Helper.generateRandomString());
            elementsNumber--;
        }

        Shortener shortener = new Shortener(strategy);

        Date idsStart = new Date();
        Set<Long> ids = getIds(shortener, strs);
        Date idsStop = new Date();
        printMessage(String.valueOf(idsStop.getTime() - idsStart.getTime()));

        Date strsStart = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date strsStop = new Date();
        printMessage(String.valueOf(strsStop.getTime() - strsStart.getTime()));

        if (strs.equals(strings))
            printMessage("Тест пройден.");
        else
            printMessage("Тест не пройден.");
    }

    public static void main(String[] args) {
        long elementsNumber = 10000;

        testStrategy(new HashMapStorageStrategy(), elementsNumber);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new OurHashBiMapStorageStrategy(), elementsNumber);
        testStrategy(new OurHashMapStorageStrategy(), elementsNumber);

        //        Map<Integer, String> map = new HashMap<>();
    }
}
