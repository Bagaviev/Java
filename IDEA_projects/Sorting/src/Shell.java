import util.Sortable;
import util.Timer;

public class Shell implements Sortable {        // вставками с изменяемым интервалом свопа (как расческа для пузырька)
    /*
    100k - 1.439 sec

    Time: o(n log2 n)        Быстрее, чем вставками
    Space: o(n) + o(1)
     */

    public int[] sort(int[] array) {
        int length = array.length;
        int step = length / 2;
        while (step > 0) {
            for (int i = 0; i < array.length - step; i++) {
                int j = i;

                while (j >= 0 && array[j] > array[j + step]) {  //сортировка вставкой внутри группы
                    int tmp = array[j];
                    array[j] = array[j + step];
                    array[j + step] = tmp;
                    j--;
                }
            }
            step /= 2;
        }
        return array;
    }

    @Override
    public void sort(int[] array, int min, int max) {
        return;
    }

    @Override
    public void sort(int[] array, int n) {
        return;
    }

    public static void main(String[] args) {
        Sortable sort = new Shell();
        System.out.println(Timer.estimateTime(sort, 100_000));
    }
}
