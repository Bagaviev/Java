import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {       // hacherRank

    /*
     * Complete the 'slowestKey' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts 2D_INTEGER_ARRAY keyTimes as parameter.
     */

    static List<item> list = new ArrayList<>();
    static Map<Integer, Character> map = new HashMap<>();

    static {
        map.put(0, 'a');
        map.put(1, 'b');
        map.put(2, 'c');
        map.put(3, 'd');
        map.put(4, 'e');
        map.put(5, 'f');
        map.put(6, 'g');
        map.put(7, 'h');
        map.put(8, 'i');
        map.put(9, 'j');
        map.put(10, 'k');
        map.put(11, 'l');
        map.put(12, 'm');
        map.put(13, 'n');
        map.put(14, 'o');
        map.put(15, 'p');
        map.put(16, 'q');
        map.put(17, 'r');
        map.put(18, 's');
        map.put(19, 't');
        map.put(20, 'u');
        map.put(21, 'v');
        map.put(22, 'w');
        map.put(23, 'x');
        map.put(24, 'y');
        map.put(25, 'z');
    }

    static class item {
        int key;
        int value;

        public item(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getKey() {
            return key;
        }

        public String toString() {
            return getKey() + " " + getValue();
        }
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {

        for (int i = 0; i < keyTimes.size() - 1; i++) {
            int element = keyTimes.get(i + 1).get(0);
            int time = keyTimes.get(i + 1).get(1) - keyTimes.get(i).get(1);
            list.add(new item(element, time));
        }

        int element = keyTimes.get(0).get(0);
        int time = keyTimes.get(0).get(1);
        list.add(new item(element, time));

        Collections.sort(list, Collections.reverseOrder(Comparator.comparing(item::getValue)));

        int maxChar = list.get(0).getKey();
        // System.out.println(list.toString());
        // System.out.println(maxChar);
        // System.out.println(map.get(maxChar));
        return map.get(maxChar);
    }
}
