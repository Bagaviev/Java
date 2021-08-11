//    Напишите приложение на Java\Groovy, которое решает следующую задачу:
//    Имеется массив строк. Необходимо определить строку, которая встречается чаще всего и вывести количество слов в данной строке.

import java.util.*;

public class Solution {
    private static String strings[];
    private static List<Item> list;

    static {
        list = new ArrayList<>();
        strings = new String[7];
        strings[0] = "This was a good day";
        strings[1] = "This was a bad day 312 win ggwp";
        strings[2] = "Once upon a time...";
        strings[3] = "Rolling the deep, i'm an astronaut";
        strings[4] = "Once upon a time...";
        strings[5] = "This was a good day";
        strings[6] = "This was a good day";
    }

    static class Item {
        private int position;
        private int counter;

        public int getPosition() {
            return position;
        }

        public int getCounter() {
            return counter;
        }

        public Item(int position, int counter) {
            this.position = position;
            this.counter = counter;
        }
    }

    public static String findMaxStr() {                     // O(n^2)
        for (int i = 0; i < strings.length; i++) {
            int cnt = 0;
            for (int j = 0; j < strings.length; j++) {      // еще можно было сделать через утильный Collections.frequencies()
                if (strings[i].equals(strings[j]))
                    cnt++;
            }
            list.add(new Item(i, cnt));
        }

        Collections.sort(list, Comparator.comparing(Item::getCounter));
        return strings[list.get(list.size() - 1).getPosition()];     // Отсортировали список по возрастанию. Взяли последний элемент.
    }

    public static int findWordCnt(String str) {
        String[] words = str.split(" ");
        return words.length;
    }

    public static void main(String[] args) {
       String result = findMaxStr();
       System.out.println(findWordCnt(result));
    }
}
