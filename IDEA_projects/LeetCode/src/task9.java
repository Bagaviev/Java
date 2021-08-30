
// https://leetcode.com/problems/palindrome-number/

public class task9 {
    public static boolean isPalindrome(int x) {
        StringBuilder input = new StringBuilder(String.valueOf(x));
        return input.toString().equals(input.reverse().toString());
    }

    public static void main(String[] args) {
        boolean result1 = isPalindrome(121);
        boolean result2 = isPalindrome(56);
        System.out.println(result1);
        System.out.println(result2);
    }
}
