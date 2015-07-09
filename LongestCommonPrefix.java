package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LongestCommonPrefix {
    @SuppressWarnings("rawtypes")
    public String longestCommonPrefix(List<String> strs) {
        if (strs.size() == 0) return "";

        Iterator it = strs.iterator();
        String prefix = (String) it.next();
        int prefixLen;

        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.length() >= prefix.length()) {
                prefixLen = prefix.length();
            } else {
                prefixLen = str.length();
                prefix = prefix.substring(0, prefixLen);
            }

            if (prefixLen == 0) return "";

            for (int i = prefixLen - 1; i >= 0; i--) {
                if (prefix.charAt(i) != str.charAt(i)) {
                    prefix = prefix.substring(0, i);
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();
        strs.add("wang");
        strs.add("wyann");

        String prefix = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(prefix);
    }
}
