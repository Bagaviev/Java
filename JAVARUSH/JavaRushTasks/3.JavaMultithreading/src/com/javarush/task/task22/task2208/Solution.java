package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", null);
        map.put("country", null);
        map.put("city", null);
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
            }
        }

        if (sb.length() > 0)
            sb.replace(sb.lastIndexOf("and"), sb.length() - 1, "");
        else
            return "";
        return sb.toString().trim();
    }
}
