package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] seq1 = word1.toCharArray();
        char[] seq2 = word2.toCharArray();

        int[][] dist = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            dist[i][0] = i;
        }
        for (int i = 1; i <= length2; i++) {
            dist[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (seq1[i - 1] == seq2[j - 1]) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    dist[i][j] = Math.min(Math.min(dist[i - 1][j - 1], dist[i - 1][j]), dist[i][j - 1]) + 1;
                }
            }
        }

        return dist[length1][length2];
    }

    public static void main(String[] args) {
        String word1 = "haha";
        String word2 = "wang";

        System.out.println(minDistance(word1, word2));
    }
}
