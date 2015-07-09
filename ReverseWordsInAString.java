package leetcode;

import java.util.Stack;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s == "") return s;
        if (!s.contains(" ")) return s;

        int len = s.length();
        int location = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                location = i;
            }
        }
        if (location == 0) {
            return s.substring(1);
        }
        if (location == len - 1) {
            return s.substring(0, len - 1);
        }
        System.out.println();
        String s1 = s.substring(location + 1);
        String s2 = s.substring(0, location);
        s = s.substring(location + 1) + " " + reverseWords(s.substring(0, location));
        return s;
    }

    public String reverseWordsV2(String s) {
        if (s == null) return null;
        s = s.trim();
        if (s == "" || !s.contains(" ")) return s;

        Stack<Integer> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ')
                stack.push(i);
        }

        int location1;
        int location2 = len;
        String rs = "";
        while (!stack.empty()) {
            location1 = stack.pop();
            if (location2 - location1 != 1)
                rs += s.substring(location1 + 1, location2) + " ";
            location2 = location1;
        }
        rs += s.substring(0, location2);

        return rs;
    }

    public static void main(String[] args) {
        //V1 is TLE, V2 can be accepted, but also a terrible time.
        String s = "yann wang     is a good programmer";
        s = new ReverseWordsInAString().reverseWordsV2(s);
        System.out.println(s);
    }
}
