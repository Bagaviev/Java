public class Main {

// первый этап был адектватным, вопросы по платформе, ревьер не пытался топить, наоборот подсказывал где-то.

/*
    По певой секции рекомендации над чем стоит поработать:
    Котлин: имеет смысл пробежаться по документации, посмотреть на возможности языка. https://kotlinlang.org/docs/home.html
    Платформа. Посмотреть, как работать с BroadcastReceiver программно.
    Смена конфигурации активити в манифесте.

    По алгоритмам, стоит нарабатывать скорость и не вязнуть в багах, когда время ограничено.
*/

/*
частичное решение второго этапа лайвкодинга

    Примеры:
            [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
            [1,4,3,2] => "1-4"
            [1,4] => "1,4"
            [1,2] => "1-2"
*/

    String concatenator(int[] array) {
        // [0,1,2,3,4,5,8,9,11]

        int[] array_sorted = array.sort();
        StringBuilder sb = new StringBuilder();

        sb.append(array_sorted[0]);

        for (int i = 0; i < array_sorted.length - 1; i++) {
            if ((array_sorted[i + 1] - array_sorted[i]) <= 1) {
                // скипнуть элемент (попадает в диапазон)
                continue;
            } else {
                // элемент нового диапазона, завершаем ранее созданный диапазон, создаем новый
                sb.append("-", array_sorted[i], ",");
                sb.append(array_sorted[i + 1]);
            }
        }

        if (sb[sb.length - 1].equals(",")) {
            sb.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1,4,5,2,3,9,8,11,0 };
        System.out.println(concatenator(array));
    }
}
