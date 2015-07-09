package leetcode;

/**
 * Created by tech4 on 2015/7/9.
 */
public class JumpGame {
    //Time Limit Exceeded.
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int length = nums.length;
        for (int i = length - 1; i >= 1; ) {
            int next = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    next = j;
                    break;
                }
            }
            if (next == -1) {
                return false;
            }
            i = next;
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int length = nums.length;

        int maxJump = 0;
        for (int i = 0; i < length; i++) {
            if (maxJump >= i) {
                maxJump = Math.max(maxJump, nums[i] + i);
            } else {
                break;
            }
        }

        return maxJump >= length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}
