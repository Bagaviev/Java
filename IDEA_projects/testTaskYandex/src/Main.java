import java.util.ArrayList;
import java.util.List;

public class Main {
    // Вставить элемент в отсортированный массив
    // [1,2,4,5]    value 3

    public static List<Integer> insertValue(List<Integer> list, int valueToInsert) {
        List<Integer> newList = new ArrayList<>(list);
        int index = getIndex(list, valueToInsert);
        newList.add(index, valueToInsert);
        return newList;
    }

    public static int getIndex(List<Integer> list, int valueToInsert) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > valueToInsert)
                return i;
        }
        return list.size();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> newList = insertValue(list, 3);
        System.out.println(newList);
    }
}
