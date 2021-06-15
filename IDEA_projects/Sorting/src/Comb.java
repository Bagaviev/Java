import util.Sortable;
import util.Timer;

public class Comb implements Sortable {     // Расческа тут ширина сравнения от большой к попарной
    /*
    100k -  ? sec (чето плохо)

    Time: o(n^2) - o(n log(n))
    Space: o(1)
     */

    public int[] sort(int[] array) {
        double factor = 1.247; // Фактор уменьшения
        double step = array.length - 1;

        while (step >= 1) {
            for (int i = 0; i + step < array.length; ++i) {
                if (array[i] > array[(int) (i + step)]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
            step /= factor;

            for (int j = array.length - 1; j > 0; j--) {
                for (int i = 0; i < j; i++) {
                    if (array[i] > array[i + 1]) {
                        int tmp = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = tmp;
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        Sortable sort = new Comb();
        System.out.println(Timer.estimateTime(sort, 20000));
    }
}
