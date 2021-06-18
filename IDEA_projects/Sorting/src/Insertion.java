import util.Sortable;
import util.Timer;

public class Insertion implements Sortable {        //  Сдвиги больших элтов вправо относительно i-ого элеманта
    /*
    100k -  6.4 sec

    Time: o(n^2 / 2)       // Быстрее, чем выбором
    Space: o(n) + o(1)
     */

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            while(j > 0 && array[j - 1] > temp) {       // элты сдвигаются влево стирая исходное temp. Затем в освободившееся
                array[j] = array[j - 1];        // место слева вставляется temp который был в памяти
                j--;
            }
            array[j] = temp;
        }
        return array;
    }

    @Override
    public void sort(int[] array, int min, int max) {
        return;
    }

    public static void main(String[] args) {
        Sortable sort = new Selection();
        System.out.println(Timer.estimateTime(sort, 100000));
    }
}
