package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if (length != s2.length()) {
            return false;
        }
        char[] seq1 = s1.toCharArray();
        char[] seq2 = s2.toCharArray();

        boolean[][][] scrambled = new boolean[length + 1][length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                scrambled[1][i][j] = (seq1[i] == seq2[j]);
            }
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j + i <= length; j++) {
                for (int k = 0; k + i <= length; k++) {
                    for (int l = 1; l < i; l++) {
                        scrambled[i][j][k] = ((scrambled[l][j][k] && scrambled[i - l][j + l][k + l]) || (scrambled[l][j][k + i - l] && scrambled[i - l][j + l][k]));
                        if (scrambled[i][j][k]) break;
                    }
                }
            }

        }
        return scrambled[length][0][0];
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgtae";
        System.out.println(isScramble(s1, s2));
    }
}
