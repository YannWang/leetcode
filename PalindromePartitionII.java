package leetcode;

/**
 * Created by tech4 on 2015/7/1.
 */
public class PalindromePartitionII {
    //forward
    public static int minCut(String s) {
        char[] seq = s.toCharArray();
        int length = s.length();
        int[] cuts = new int[length + 1];
        cuts[length] = -1;
        for (int i = 0; i < length; i++) {
            cuts[i] = length - i - 1;
        }
        boolean[][] isPalindrome = new boolean[length][length];

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (seq[i] == seq[j] && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0];
    }

    //backward
    public int minCut2(String s) {
        int length = s.length();
        char[] seq = s.toCharArray();
        int[] cuts = new int[length + 1];
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i <= length; i++) {
            cuts[i] = i - 1;
        }

        for (int j = 0; j < length; j++) {
            for (int i = j; i >= 0; i--) {
                if ((seq[i] == seq[j]) && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    cuts[j + 1] = Math.min(cuts[j + 1], cuts[i] + 1);
                }
            }
        }
        return cuts[length];
    }

    public static int minCut3(String s) {
        char[] seq = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] cuts = new int[seq.length + 1];
        for (int i = 0; i < cuts.length; i++) {
            cuts[i] = i - 1;
        }
        for (int j = 0; j < seq.length; j++) {
            for (int i = j; i >= 0; i--) {
                if (seq[i] == seq[j] && (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    cuts[j + 1] = Math.min(cuts[j + 1], cuts[i] + 1);
                }
            }
        }
        return cuts[seq.length];
    }

    public static void main(String[] args) {
        String s1 = "aab";
        String s2 = "";
        String s3 = "ccaacabacb";

        System.out.println(minCut3(s1));
        System.out.println(minCut3(s2));
        System.out.println(minCut3(s3));
    }

}
