package leetcode;

/**
 * Created by tech4 on 2015/7/3.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[][] ways = new int[length + 1][length];

        for (int i = 0; i < length; i++) {
            ways[0][i] = 1;
            ways[1][i] = codeWays(s.substring(i, i + 1));
        }
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                ways[i][j] = ways[i - 1][j] * codeWays(s.substring(j + i - 1, j + i)) + ways[i - 2][j] * codeWays(s.substring(j + i - 2, j + i));
            }
        }
        return ways[length][0];
    }

    private int codeWays(String s) {
        if (s.startsWith("0")) return 0;
        int num = Integer.valueOf(s);
        if (0 < num && num < 27) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        String s = "01";
        System.out.println(dw.numDecodings(s));
    }
}
