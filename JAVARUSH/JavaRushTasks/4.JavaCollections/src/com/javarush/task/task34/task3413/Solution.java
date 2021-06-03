package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();
        Map<Long, AnyObject> map = new HashMap<>();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }

        System.out.println(map.get(666L));

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        System.out.println(memoryBean.getHeapMemoryUsage().getUsed() / (1024 * 1024));
    }
}