package leetcode;

import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == end)
            return 0;
        return 0;
    }

    int wordDist(String a, String b) {
        int dist = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                dist++;
        }

        return dist;
    }
}
