import java.io.*;
import java.util.*;

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

        tmp.iterator().hasNext();
        tmp.iterator().next();
        tmp.iterator().remove();

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