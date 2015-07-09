package leetcode;

/**
 * Created by tech4 on 2015/7/7.
 */
public class InterleavingString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) return false;
        char[] seq1 = s1.toCharArray();
        char[] seq2 = s2.toCharArray();
        char[] seq3 = s3.toCharArray();

        //Here, mat[i][j] is true if s3.substring(0,i) is interleaving of
        //s1.substring(0,j) and s2.substring(0,i-j)
        boolean[][] mat = new boolean[len3 + 1][len1 + 1];
        mat[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) mat[i][0] = true;
        }
        for (int i = 1; i <= len3; i++) {
            for (int j = 1; j <= Math.min(i, len1); j++) {
                if (seq3[i - 1] == seq1[j - 1] && mat[i - 1][j - 1]) {
                    mat[i][j] = true;
                }
                if ((i - j - 1) >= 0 && (i - j - 1) < len2 && seq3[i - 1] == seq2[i - j - 1] && mat[i - 1][j]) {
                    mat[i][j] = true;
                }
            }
        }

        return mat[len3][len1];
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        System.out.println(isInterleave(s1, s2, s3));
    }
}
