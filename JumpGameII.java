package leetcode;

/**
 * Created by tech4 on 2015/6/29.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        return greedyJump(nums, nums.length - 1);
    }

    private int greedyJump(int[] nums, int end) {
        int nextIndex = end - 1;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] >= end - i) {
                nextIndex = i;
            }
        }
        if (nextIndex == 0) return 1;
        else return greedyJump(nums, nextIndex) + 1;
    }

    public static int jump2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int length = nums.length;
        int count = 0;

        for (int i = length - 1; i >= 1; ) {
            int next = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    count++;
                    next = j;
                    break;
                }
            }
            if (next == -1) return -1;
            i = next;
        }

        return count;
    }

    public static int jump3(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int length = nums.length;

        int count = 1;
        int maxNext = nums[0];
        int currentRange = nums[0];
        for (int i = 1; i <= length - 1; i++) {
            if (currentRange >= length - 1) return count;
            if (i <= currentRange) {
                if (nums[i] + i > maxNext) {
                    maxNext = nums[i] + i;
                }
                if (i == currentRange && maxNext > currentRange) {
                    count++;
                    currentRange = maxNext;
                }
            } else {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        System.out.println(jump3(nums));
    }
}
