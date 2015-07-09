package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChracters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int length = 0;

        char currentChar;
        int index = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            if (indexMap.containsKey(currentChar)) {
                if (length < (i - index)) {
                    length = i - index;
                }
                int end = indexMap.get(currentChar);
                indexMap = clearMap(indexMap, s.substring(index, end + 1));
                index = end + 1;
                indexMap.put(currentChar, i);
            } else {
                indexMap.put(currentChar, i);
            }
        }

        if (length < indexMap.size()) {
            length = indexMap.size();
        }

        return length;
    }

    public static HashMap<Character, Integer> clearMap(
            HashMap<Character, Integer> indexMap, String s) {
        for (int i = 0; i < s.length(); i++) {
            indexMap.remove(s.charAt(i));
        }
        return indexMap;
    }

    public static void main(String[] args) {
        String s = "successful";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
