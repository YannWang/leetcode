package leetcode;

/**
 * Created by tech4 on 2015/6/29.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int length = s.length();
        if (length <= 1) return 0;
        boolean[][] isValid = new boolean[length + 1][length];
        int max = 0;
        char[] seq = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            if (seq[i] == '(' && seq[i + 1] == ')') {
                isValid[2][i] = true;
                max = 2;
            }
        }

        for (int l = 4; l <= length; l = l + 2) {
            for (int i = 0; i <= length - l; i++) {
                if (seq[i] == '(' && seq[i + l - 1] == ')') {
                    if (isValid[l - 2][i + 1]) {
                        isValid[l][i] = true;
                        max = l;
                        continue;
                    }
                }
                for (int j = 2; j <= l - 2; j = j + 2) {
                    if (isValid[j][i] && isValid[l - j][i + j]) {
                        isValid[l][i] = true;
                        max = l;
                        break;
                    }
                }
            }
            if (max < l) break;
        }
        return max;
    }

    public static void main(String[] args) {
        String[] ss = {"(()", ")()()", ""};
        for (int i = 0; i < ss.length; i++) {
            System.out.println(longestValidParentheses(ss[i]));
        }
    }
}
