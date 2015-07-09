package leetcode;

public class RegularExpressionMatching {
    public boolean isMatching(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean flag = false;
        //regex does not contain '*'
        if (!p.contains("*")) {
            if (s.length() != p.length()) {
                return false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (p.charAt(i) != '.' && p.charAt(i) != s.charAt(i)) {
                        return false;
                    }
                }
            }
            return true;
        } else {

        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println("".length());
    }
}
