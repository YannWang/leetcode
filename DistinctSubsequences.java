package leetcode;

/**
 * Created by tech4 on 2015/7/7.
 */
public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (tl == 0) return 1;
        else if (sl == 0) return 0;

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int[][] mat = new int[sl + 1][tl + 1];

        for (int i = 0; i <= sl; i++) {
            mat[i][0] = 1;
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (ss[i - 1] != ts[j - 1]) mat[i][j] = mat[i - 1][j];
                else mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
            }
        }

        return mat[sl][tl];
    }

    public static void main(String[] args) {
        String s = "";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }
}
