import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String[] sizeInput = reader.readLine().split(" ");
            int h = Integer.valueOf(sizeInput[0]);
            int w = Integer.valueOf(sizeInput[1]);

            String[] horizontalLinesInput = reader.readLine().split(" ");

            Integer[] horizontalLinesY = new Integer[horizontalLinesInput.length];
            for (int i = 0; i < horizontalLinesInput.length; i++) {
                horizontalLinesY[i] = Integer.valueOf(horizontalLinesInput[i]);
            }

            String[] verticalLinesInput = reader.readLine().split(" ");

            Integer[] verticalLinesX = new Integer[verticalLinesInput.length];
            for (int i = 0; i < verticalLinesInput.length; i++) {
                verticalLinesX[i] = Integer.valueOf(verticalLinesInput[i]);
            }

            Integer[] area = maxArea(h, w, horizontalLinesY, verticalLinesX);
            System.out.println(Arrays.toString(area));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Integer[] maxArea(int h, int w, Integer[] horizontalLinesY, Integer[] verticalLinesX) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<Integer> rawX = new ArrayList(Arrays.asList(verticalLinesX));
        rawX.add(0);
        rawX.add(w);
        Collections.sort(rawX);

        ArrayList<Integer> rawY = new ArrayList(Arrays.asList(horizontalLinesY));
        rawY.add(0);
        rawY.add(h);
        Collections.sort(rawY);

        for (int i = 0; i < rawX.size() - 1; i++) {
            tmp.add(Math.abs(rawX.get(i) - rawX.get(i + 1)));
        }

        int maxDistanceX = Collections.max(tmp);
        tmp.clear();

        for (int i = 0; i < rawY.size() - 1; i++) {
            tmp.add(Math.abs(rawY.get(i) - rawY.get(i + 1)));
        }

        int maxDistanceY = Collections.max(tmp);

        System.out.println(maxDistanceX * maxDistanceY);
        return tmp.toArray(new Integer[tmp.size()]);
    }
}
*/

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");
        int h = Integer.valueOf(sizeInput[0]);
        int w = Integer.valueOf(sizeInput[1]);

        String[] horizontalLinesInput = sc.nextLine().split(" ");

        Integer[] horizontalLinesY = new Integer[horizontalLinesInput.length];
        for (int i = 0; i < horizontalLinesInput.length; i++) {
            horizontalLinesY[i] = Integer.valueOf(horizontalLinesInput[i]);
        }

        String[] verticalLinesInput = sc.nextLine().split(" ");

        Integer[] verticalLinesX = new Integer[verticalLinesInput.length];
        for (int i = 0; i < verticalLinesInput.length; i++) {
            verticalLinesX[i] = Integer.valueOf(verticalLinesInput[i]);
        }

        long area = maxArea(h, w, horizontalLinesY, verticalLinesX);
        System.out.println(area);
    }

    private static long maxArea(int h, int w, Integer[] horizontalLinesY, Integer[] verticalLinesX) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        ArrayList<Integer> rawX = new ArrayList(Arrays.asList(verticalLinesX));
        rawX.add(0);
        rawX.add(w);
        Collections.sort(rawX);

        ArrayList<Integer> rawY = new ArrayList(Arrays.asList(horizontalLinesY));
        rawY.add(0);
        rawY.add(h);
        Collections.sort(rawY);

        for (int i = 0; i < rawX.size() - 1; i++) {
            tmp.add(Math.abs(rawX.get(i) - rawX.get(i + 1)));
        }

        int maxDistanceX = Collections.max(tmp);
        tmp.clear();

        for (int i = 0; i < rawY.size() - 1; i++) {
            tmp.add(Math.abs(rawY.get(i) - rawY.get(i + 1)));
        }

        int maxDistanceY = Collections.max(tmp);

        return maxDistanceX * maxDistanceY;
    }
}