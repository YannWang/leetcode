package leetcode;

import java.util.*;

/**
 * Created by tech4 on 2015/7/16.
 */
public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (map.containsKey(nums[i])) {
                for (int num : map.get(nums[i])) {
                    if (i - num > k) {
                        break;
                    }
                    if (Math.abs(nums[i] - nums[num]) <= Math.abs(t)) {
                        return true;
                    }
                }
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.addAll(map.get(nums[i]));
                map.put(nums[i], list);
            } else {
                List<Integer> list = Arrays.asList(i);
                map.put(nums[i], list);
            }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1};
        int k = 1;
        int t = -1;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
