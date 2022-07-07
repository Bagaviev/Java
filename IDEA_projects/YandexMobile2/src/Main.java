import java.util.Scanner;
import java.util.Stack;

public class Main {

    // abc. abd.
    // true

    // aaa.. bbb..
    // false

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] sizeInput = sc.nextLine().split(" ");

        System.out.println(convertInput(sizeInput[0]).equals(convertInput(sizeInput[1])));


    }

    private static String convertInput(String str1) {
        Stack<Character> chars = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '.')
                chars.push(str1.charAt(i));
            else if (!chars.isEmpty())
                chars.pop();
        }

        for (char c: chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
