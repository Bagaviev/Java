import util.Sortable;
import util.Timer;

public class Insertion {        //
    /*
    100k -  6.4 sec

    Time: o(n^2 - n)       // Быстрее, чем выбором
    Space: o(n) + o(1)
     */

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i;

            while(j > 0 && array[j - 1] > temp) {
                array[j - 1] = array[j];
                j--;
            }
            array[j] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        Sortable sort = new Selection();
        System.out.println(Timer.estimateTime(sort, 100000));
    }
}
