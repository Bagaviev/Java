import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestTask {
    static String strs[];
    static List<Item> list;

    static class Item {
        int position;
        int counter;

        public Item(int position, int counter) {
            this.position = position;
            this.counter = counter;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "position=" + position +
                    ", counter=" + counter +
                    '}';
        }
    }

    static {
        strs = new String[6];
        strs[0] = "str1";
        strs[1] = "str2";
        strs[2] = "str2";
        strs[3] = "str2";
        strs[4] = "str3";
        strs[5] = "str3";

        list = new ArrayList();
    }

    public static void fillList() {
        for (int i = 0; i < strs.length; i++) {
            int cnt = 0;
            for (int j = 0; j < strs.length; j++) {
                if (strs[i].equals(strs[j]))
                    cnt++;
            }
            list.add(new Item(i, cnt));
        }
    }

    public static void sortList() {
        Collections.sort(list, Comparator.comparing(Item::getCounter));
    }

    public static String getLast() {
        return strs[(list.get(list.size() - 1).getPosition())];
    }

    public static void main(String[] args) {
        fillList();
        sortList();
        System.out.println(list);
        System.out.println(getLast());
    }
}
