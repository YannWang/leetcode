package leetcode;

/**
 * Created by tech4 on 2015/6/29.
 */
public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        if (s == "" && p == "") return true;
        if (s == "" || p == "") return false;

        int i = 0;
        while (i < s.length() && i < p.length() && (s.charAt(i) == p.charAt(i) || p.charAt(i) == '?')) {
            i++;
        }
        if (i == p.length()) {
            if (i == s.length()) return true;
            else return false;
        }
        if (i == s.length()) {
            char[] remain = p.substring(i).toCharArray();
            for (char c : remain) {
                if (c != '*') return false;
            }
            return true;
        }
        if (p.charAt(i) != '*') return false;
        else {
            int j = i;
            while (j < p.length() && p.charAt(j) == '*') j++;
            String pp = p.substring(j);
            while (i <= s.length()) {
                if (isMatch(s.substring(i), pp)) return true;
                i++;
            }
            return false;
        }
    }

    public boolean isMatch2(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if (sl == 0 && pl == 0) return true;
        if (sl == 0) {
            if (p.charAt(pl - 1) == '*') return isMatch2(p.substring(0, pl - 1), s);
            else return false;
        }
        if (pl == 0) return false;

        if (p.charAt(pl - 1) == '?' || s.charAt(sl - 1) == p.charAt(pl - 1)) {
            return isMatch2(s.substring(0, sl - 1), p.substring(pl - 1));
        } else if (p.charAt(pl - 1) == '*') {
            //过滤掉多个*
            while (pl - 1 >= 0 && p.charAt(pl - 1) == '*') pl--;
            for (int i = 0; i <= sl; i++) {
                String sp = s.substring(0, sl - i);
                String pp = p.substring(0, pl);
                if (isMatch2(sp, pp) == true) return true;
//                if (isMatch2(s.substring(0, sl - i), p.substring(0, pl - 1)) == true) return true;
            }
        }

        return false;
    }

    public boolean isMatch3(String s, String p) {
        boolean[][] matchMatrix = new boolean[p.length() + 1][s.length() + 1];
        matchMatrix[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            matchMatrix[0][i] = false;
        }
        for (int i = 1; i <= p.length(); i++) {
            char pattern = p.charAt(i - 1);
            matchMatrix[i][0] = matchMatrix[i - 1][0] && pattern == '*';
            for (int j = 1; j <= s.length(); j++) {
                char letter = s.charAt(j - 1);
                if (pattern != '*') {
                    matchMatrix[i][j] = matchMatrix[i - 1][j - 1] && (pattern == '?' || pattern == letter);
                } else {
                    matchMatrix[i][j] = matchMatrix[i - 1][j] || matchMatrix[i][j - 1];
                }
            }
        }

        return matchMatrix[p.length()][s.length()];
    }

    //backward dynamic programming
    //Memory Limit Exceeded.
    public static boolean isMatch4(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        char[] sseq = s.toCharArray();
        char[] pseq = p.toCharArray();

        short[][] isMatch = new short[pl + 1][sl + 1];
        isMatch[0][0] = 1;

        for (int i = 0; i < pl; i++) {
            for (int j = 0; j < sl; j++) {
                if (pseq[i] == '?' || pseq[i] == sseq[j]) {
                    isMatch[i + 1][j + 1] = isMatch[i][j];
                } else if (pseq[i] == '*') {
                    for (int k = 0; k <= j + 1; k++) {
                        if (isMatch[i][k] == 1) {
                            isMatch[i + 1][j + 1] = 1;
                            break;
                        }
                    }
                } else {
                    isMatch[i + 1][j + 1] = 0;
                }
            }
        }

        return (isMatch[pl][sl] == 1) ? true : false;
    }

    //backtracking solution
    public static boolean isMatch5(String s, String p) {
        int ps = 0, pp = 0, match = 0, starIndex = -1;
        char[] sseq = s.toCharArray();
        char[] pseq = p.toCharArray();
        while (ps < s.length()) {
            if (pp < p.length() && (sseq[ps] == pseq[pp] || pseq[pp] == '?')) {
                ps++;
                pp++;
            } else if (pp < p.length() && pseq[pp] == '*') {
                starIndex = pp;
                match = ps;
                pp++;
            } else if (starIndex != -1) {
                pp = starIndex + 1;
                match++;
                ps = match;
            } else {
                return false;
            }
        }

        while (pp < p.length() && pseq[pp] == '*') pp++;

        return pp == p.length();
    }

    public static void main(String[] args) {
        String[] ss = {"aa", "aa", "aaa", "aa", "aa", "ab", "aab"};
        String[] ps = {"a", "aa", "aa", "*", "a*", "?*", "c*a*b"};
        boolean[] match = {false, true, false, true, true, true, false};

        //test
        for (int i = 0; i < ss.length; i++) {
            System.out.println(match[i] == isMatch5(ss[i], ps[i]));
        }
//
//        String s = "aab";
//        String p = "c*a*b";
//        System.out.println(isMatch4(s, p));
    }
}
