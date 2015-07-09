package leetcode;

import java.util.*;

/**
 * Created by tech4 on 2015/6/26.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) return list;
        int wordLength = words[0].length();
        int wordsStringLength = words.length * wordLength;

        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            int times = wordsMap.containsKey(word) ? wordsMap.get(word) : 0;
            wordsMap.put(word, times + 1);
        }

        for (int i = 0; i <= s.length() - wordsStringLength; i++) {
            int index = i;
            while (index <= s.length() - wordLength) {
                String word = s.substring(index, index + wordLength);
                if (wordsMap.containsKey(word) && wordsMap.get(word) != 0) {
                    wordsMap.put(word, wordsMap.get(word) - 1);
                    index += wordLength;
                } else {
                    break;
                }
            }

            if (index - i == wordsStringLength) list.add(i);
            recoverMap(s.substring(i, index), wordLength, wordsMap);

        }
        return list;
    }

    private void recoverMap(String s, int length, Map<String, Integer> map) {
        if (s == "") return;
        int wordsNum = s.length() / length;
        for (int i = 0; i < wordsNum; i++) {
            String word = s.substring(i * length, (i + 1) * length);
            map.put(word, map.get(word) + 1);
        }
    }

    public static void main(String[] args) {
        String s = "abababab";
        String[] words = {"a", "b", "a"};
        List<Integer> list = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
