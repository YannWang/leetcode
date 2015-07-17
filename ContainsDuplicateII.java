package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tech4 on 2015/7/16.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) return true;
            else map.put(nums[i], i);
        }
        return false;
    }
}
