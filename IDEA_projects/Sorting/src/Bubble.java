    import util.Sortable;
import util.Timer;

   /*
    100k - 22 sec

    Time: o(n^2)
    Space: o(1)
     */

public class Bubble implements Sortable {       // попарное сравнение и уменьшение размера прохода с каждым проходом

    public int[] sort(int[] array) {        // вот это тру пузырек
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
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

    // ALTERNATIVE MY VARIANT (Это не совсем каноничный пузырек, гибрид пузырька и выбором)      // 7 сек
       /* for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {  // самое мелкое всплывет слева как говно в воде
                    int tmp = array[i];         // значит можно итерироваться в след шаге на позицию меньше, чем раньше
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }*/

    public static void main(String[] args) {
        Sortable sort = new Bubble();
        System.out.println(Timer.estimateTime(sort, 100_000));        // нули справа могут быть если size меньше 6 указан, это норма
    }
}
