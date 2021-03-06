import util.Sortable;
import util.Timer;

public class Cocktail implements Sortable {     // Шейкерная, пузырек в два действия за проход (мин-макс)
       /*
    100k -  14 sec

    Time: o(n^2)
    Space: o(1)
     */

    public int[] sort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
                for (int i = left; i < right; i++) {
                    if (array[i] > array[i + 1]) {
                        int tmp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = tmp;
                    }
                }
                right--;
                for (int i = right; i > left; i--) {
                    if (array[i] < array[i - 1]) {
                        int tmp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = tmp;
                    }
                }
                left++;
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
        Sortable sort = new Cocktail();
        System.out.println(Timer.estimateTime(sort, 100_000));
    }
}
