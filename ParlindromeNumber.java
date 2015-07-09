package leetcode;

public class ParlindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        int bitNum = 0;
        if (x > 0) {
            bitNum = (int) Math.log10(x);
        } else {
//			if (x == - 2147483648) {
//				return false;
//			}
//			else {
//				bitNum = (int) Math.log10(-x);
//				x = -x;
//			}
            return false;
        }

        int low = 0;
        int high = bitNum;
        while (high >= low) {
            if ((int) (x / Math.pow(10, high) % 10) != (int) (x / Math.pow(10, low) % 10)) {
                return false;
            }
            high--;
            low++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
