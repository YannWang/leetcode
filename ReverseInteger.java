package leetcode;

public class ReverseInteger {
    public static int reverse(int n) {
        if (n == 0) return n;

        long val = n;
        long rev = 0;
        boolean sign;
        if (n > 0) {
            sign = true;
        } else {
            sign = false;
            val = -val;
        }

        int mode = 10;
        int quotient;
        int remainder;
        while (true) {
            remainder = (int) (val % mode);
            quotient = (int) (val / mode);

            val = quotient;
            rev = rev * 10 + remainder;
            if (quotient == 0) {
                break;
            }
        }

        if (!sign) {
            rev = -rev;
        }
        if (rev < -2147483648 || rev > 2147483647)
            rev = 0;
        return (int) rev;
    }

    public static void main(String[] args) {
        int num = -2147483648;
        //int num = 100;
        System.out.println(reverse(num));
    }
}
