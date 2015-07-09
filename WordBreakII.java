package leetcode;

import java.util.*;

/**
 * Created by tech4 on 2015/7/1.
 */
public class WordBreakII {
    //Time Limit Exceeded.
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == "") return null;
        int length = s.length();
        boolean[] canBreak = new boolean[length + 1];
        canBreak[0] = true;
        //segMap.get(i) string forms that s.substring(0,i+1) can be segmented.
        Map<Integer, Set<String>> segMap = new HashMap<>();
        for (int i = 0; i <= length; i++) {
            Set<String> segSentence = new HashSet<>();
            segMap.put(i, segSentence);
        }
        segMap.get(0).add("");

        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                String word = s.substring(i, j + 1);
                if (wordDict.contains(word) && canBreak[i]) {
                    canBreak[j + 1] = true;
                    for (String sentence : segMap.get(i)) {
                        segMap.get(j + 1).add((sentence + " " + word).trim());
                    }
                }
            }
        }

        List<String> list = new ArrayList<>();
        list.addAll(segMap.get(length));
        return list;
    }

    public static List<String> wordBreak2(String s, Set<String> wordDict) {
        if (s == null) return null;
        int length = s.length();
        if (length == 0) return null;
        boolean[] canBreak = new boolean[length + 1];
        canBreak[0] = true;
        boolean[][] isWord = new boolean[length][length + 1];

        for (int i = 1; i < length + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canBreak[j] && wordDict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    isWord[j][i] = true;
                }
            }
        }

        return genList(s, s.length(), isWord);
    }

    private static List<String> genList(String s, int reIndex, boolean[][] isWord) {
        List<String> list = new ArrayList<>();
        if (reIndex == 0) {
            list.add("");
            return list;
        }
        for (int i = 0; i < reIndex; i++) {
            if (isWord[i][reIndex]) {
                for (String subSen : genList(s, i, isWord)) {
                    list.add((subSen + " " + s.substring(i, reIndex)).trim());
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        Set<String> wordDict = new HashSet<>();
        wordDict.addAll(list);

        List<String> retList = wordBreak2(s, wordDict);
        System.out.println(Arrays.toString(retList.toArray()));
    }
}
