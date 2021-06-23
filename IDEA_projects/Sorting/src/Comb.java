import util.Sortable;
import util.Timer;

public class Comb implements Sortable {     // Расческа тут ширина сравнения от большой к попарной
    /*
    100k -  0.034 sec (хуя)

    Time: o(n^2) - o(n log(n))
    Space: o(1)
     */

    public int[] sort(int[] array) {
        double fact = 1.2473309; // фактор уменьшения
        int step = array.length - 1;

        while (step >= 1) {
            for (int i = 0; i + step < array.length; ++i) {
                if (array[i] > array[i + step]) {
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                }
            }
            if (step == 1) break;
            step = (int) (step / fact);
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
        Sortable sort = new Comb();
        System.out.println(Timer.estimateTime(sort, 100_000));
    }
}
