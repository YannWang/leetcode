package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tech4 on 2015/7/16.
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return null;
        int start = nums[0], end = nums[0];
        String range;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                if (start == end) {
                    range = start + "";
                } else {
                    range = start + "->" + end;
                }
                list.add(range);
                start = nums[i];
                end = nums[i];
            } else {
                end++;
            }
        }
        if (start == end) {
            range = start + "";
        } else {
            range = start + "->" + end;
        }
        list.add(range);
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 4, 5, 7, 12, 13, 14, 15, 17, 19, 20};
        int[] nums = {4};
        List<String> list = summaryRanges(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
