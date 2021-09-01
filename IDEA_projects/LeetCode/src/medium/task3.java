package medium;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

public class task3 {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}

/*
 public static int lengthOfLongestSubstring(String s) {
        int currentSubStr = 0;
        int maxSubStr = 0;
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (sb.indexOf(String.valueOf(array[i])) == -1) {
                sb.append(array[i]);
                currentSubStr++;
            } else {
                sb.delete(0, sb.length());
                currentSubStr = sb.length();
                sb.append(array[i]);
                currentSubStr++;

                if (currentSubStr > maxSubStr)
                    maxSubStr = currentSubStr;
            }
                if (currentSubStr > maxSubStr)
                    maxSubStr = currentSubStr;
        }
        return maxSubStr;
    }
 */