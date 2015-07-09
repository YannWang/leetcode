package leetcode;

import java.util.List;

/**
 * Created by tech4 on 2015/7/3.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        if (size < 2) {
            return intervals;
        }
        for (int i = 1; i < intervals.size(); i++) {
            for (int j = 0; j < i; j++) {
                Interval fi = intervals.get(j);
                Interval bi = intervals.get(i);
//                if ((fi.start <= bi.start && fi.end >= bi.end) || ())
            }
        }
        return intervals;
    }
}
