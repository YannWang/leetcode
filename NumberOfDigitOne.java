package leetcode;

/**
 * Created by tech4 on 2015/7/15.
 */
public class NumberOfDigitOne {
    //Time Limit Exceeded.
    public static int countDigitOne(int n) {
        if (n <= 0) return 0;
        int count = 0;
        String s;
        for (int i = 1; i <= n; i++) {
            s = String.valueOf(i);
            if (s.contains("1")) {
                char[] seq = s.toCharArray();
                for (char c : seq) {
                    if (c == '1') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }
}
