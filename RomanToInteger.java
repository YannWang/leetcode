package leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public int RomanToInt(String s) {
        int result = 0;
        char[] alpha = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        HashMap<Character, Integer> alphaMap = new HashMap<Character, Integer>();

        for (int i = 0; i < alpha.length; i++) {
            alphaMap.put(alpha[i], value[i]);
        }

        int length = s.length();
        char cb, ca;
        for (int i = 0; i < length - 1; i++) {
            cb = s.charAt(i);
            ca = s.charAt(i + 1);
            if (alphaMap.get(cb) >= alphaMap.get(ca)) {
                result += alphaMap.get(cb);
            } else {
                result -= alphaMap.get(cb);
            }
        }
        result += alphaMap.get(s.charAt(length - 1));

        return result;
    }
}
