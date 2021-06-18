import util.Sortable;
import util.Timer;

   /*
    7k - 18 sec

    Time: o(n^3)    // log(45)18000 = 2.6 ~ 3
    Space: o(1)
     */

public class Dumb implements Sortable {

    public int[] sort(int[] array) {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int t = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = t;
                    end = false;
                    break;
                }
            }
        }
        return array;
    }

    @Override
    public void sort(int[] array, int min, int max) {
        return;
    }

    public static void main(String[] args) {
        Sortable sort = new Dumb();
        System.out.println(Timer.estimateTime(sort, 7000));        // нули справа могут быть если size меньше 6 указан, это норма
    }
}
