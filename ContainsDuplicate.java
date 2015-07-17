package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tech4 on 2015/7/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return false;
            else set.add(num);
        }
        return true;
    }
}
