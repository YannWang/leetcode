package leetcode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String palindrome = "";
        if (s == null) return s;
        if (s.length() <= 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return s;

        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxLen = 2;
                index = i;
                break;
            }
            if (s.charAt(i) == s.charAt(i + 2)) {
                maxLen = 3;
                index = i;
                break;
            }
        }

        for (int i = index; i < s.length(); i++) {
            if (s.substring(i - maxLen, i).equals(reverseString(s.substring(i + 1, i + 1 + maxLen)))) {

            }
        }
        return palindrome;
    }

    public static String reverseString(String s) {
        StringBuilder reverse = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
        String s = "wang yann";
        System.out.println(reverseString(s));
        System.out.println(s.substring(5, 9));
    }
}
