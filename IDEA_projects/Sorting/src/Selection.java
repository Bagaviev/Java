import util.Sortable;
import util.Timer;

public class Selection implements Sortable {        // поиск минимума и обмен позициями с текущим элементом
    /*
    100k - 7 sec (прямо как мой пузырек, тк это был аналог выбором, только не заменой, а перестановками)

    Time: o(n^2)        Быстрее, чем пузырек
    Space: o(n)
     */

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int least = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[least])
                    least = j;
            }
            int tmp = array[i];
            array[i] = array[least];
            array[least] = tmp;
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
