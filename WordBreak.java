package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tech4 on 2015/7/1.
 */
public class WordBreak {
    //backward
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s == "") return false;
        int length = s.length();
        boolean[] canBreak = new boolean[length + 1];
        canBreak[0] = true;

        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (wordDict.contains(s.substring(i, j + 1)) && canBreak[i]) {
                    canBreak[j + 1] = true;
                    break;
                }
            }
        }
        return canBreak[length];
    }

    public static void main(String[] args) {
        String s = "a";
        Set<String> wordDict = new HashSet<>();
        wordDict.add("a");
//        wordDict.add("leet");
//        wordDict.add("code");

        System.out.println(wordBreak(s, wordDict));
    }
}
