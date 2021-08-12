import java.io.BufferedReader;

/*
public class Task {
    static String input;
    static int rows;
    static int cols;

    static {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
            String[] nums = input.split(" ");
            rows = Integer.parseInt(nums[1]);
            cols = Integer.parseInt(nums[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long[][] map = new long[rows][cols];
        long rowCnt = 0;
        long colCnt = 0;

        for (int row_min = 0; row_min < rows; row_min++)
            for (int row_max = row_min; row_max < rows; row_max++)
                for (int col_min = 0; col_min < cols; col_min++)
                    for (int col_max = col_min; col_max < cols; col_max++) {
                        for (int i = row_min; i <= row_max; i++)
                            for (int j = col_min; j <= col_max; j++)
                                map[i][j]++;
                    }

//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

//        System.out.println();

        for (int i = 0; i < map.length; i++) {
            rowCnt = 0;
            for (int j = 0; j < map[i].length; j++) {
                rowCnt += map[i][j];
            }
            System.out.print(rowCnt + " ");
        }

        System.out.println();

        for (int i = 0; i < map[0].length; i++) {
            colCnt = 0;
            for (int j = 0; j < map.length; j++) {
                colCnt += map[j][i];
            }
            System.out.print(colCnt + " ");
        }
    }
}
*/

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    static class item {     // через treemap не работает, массив тоже нах
        int value;
        String key;

        public item(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }
    }

    public static void main(String[] args) {
        try {
            List<item> fineStrings = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            Matcher matcher = null;
            Integer num = null;
            Pattern pattern = Pattern.compile("[0-9]+");
            String str2;

            while ((str2 = reader.readLine()) != null) {
                matcher = pattern.matcher(str2);

                while (matcher.find()) {
                    num = Integer.parseInt(matcher.group());
                    fineStrings.add(new item(str2.replaceAll("[0-9]", ""), num));
                }

            }

            Collections.sort(fineStrings, Comparator.comparing(item::getValue));

            for (int i = 0; i < fineStrings.size(); i++) {
                writer.write(fineStrings.get(i).getKey());
                writer.newLine();
            }

            reader.close();
            writer.close();

        } catch (Exception e) {
        }
    }
}