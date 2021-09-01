package easy;
// https://leetcode.com/problems/factorial-trailing-zeroes/

public class task172 {
    public int trailingZeroes(int n) {  // какая-то магия, индус порешал опять все...
        int count = 0;

        while (n > 0) {
            n /= 5;         // неочевидно ни ку я
            count += n;
        }

        return count;
    }

    public static long factorial(int n) {    // сам, без подсказок!
        if (n == 0 || n < 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        task172 obj = new task172();
        System.out.println(obj.trailingZeroes(30));
    }
}

/*
 public int trailingZeroes(int n) {      // not funny, didn't laugh
        int cnt = 0;
        BigInteger result = factorial(n);
        System.out.println(result.toString());
        while (result.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
            result = result.divide(BigInteger.valueOf(10));
            cnt++;
        }
        return cnt;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        BigInteger m = BigInteger.valueOf(n);

        while (!m.equals(BigInteger.ZERO)) {
            result = result.multiply(m);
            m = m.subtract(BigInteger.ONE);
        }
        return result;
    }

    public static void main(String[] args) {
        easy.task172 obj = new easy.task172();
        System.out.println(obj.trailingZeroes(30));
    }
 */

/*
public class easy.task172 {
    public int trailingZeroes(int n) {
        int cnt = 0;
        BigInteger result = factorial(n);
        while (result.mod(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {    // збс, четко...
            result = result.divide(BigInteger.valueOf(10));         // BigInteger вынужденный костыль, чтобы прожевать n > 30
            cnt++;
        }
        return cnt;
    }

    public static BigInteger factorial(int n) {    // сам, без подсказок!
        if (n == 0 || n < 0)
            return new BigInteger(String.valueOf(1));
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static void main(String[] args) {
        easy.task172 obj = new easy.task172();
        System.out.println(obj.trailingZeroes(30));
    }
}
 */

/*
class Solution {
     public int trailingZeroes(int n) {
        int cnt = 0;
        long result = factorial(n);
        while (result % 10 == 0) {    // збс, четко...
            result /= 10;
            cnt++;
        }
        return cnt;
    }

    public static long factorial(int n) {    // сам, без подсказок!
        if (n == 0 || n < 0)
            return 1;
        return n * factorial(n - 1);
    }
}
 */