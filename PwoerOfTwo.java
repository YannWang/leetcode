package leetcode;

/**
 * Created by tech4 on 2015/7/15.
 */
public class PwoerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (true) {
            if ((n % 2) != 0) {
                n = n / 2;
                break;
            } else {
                n /= 2;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            if (isPowerOfTwo(i)) System.out.println(i + ": " + isPowerOfTwo(i));
        }

    }
}
