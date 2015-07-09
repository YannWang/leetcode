package leetcode;

/**
 * Created by tech4 on 2015/7/2.
 */
public class HouseRobberII {
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] maxValue = new int[length + 1];

        //without first
        int value = nums[0];
        nums[0] = 0;
        maxValue[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + nums[i - 1]);
        }
        int max = maxValue[length];

        //without last
        nums[0] = value;
        nums[length - 1] = 0;
        maxValue[1] = nums[0];
        for (int i = 2; i <= length; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + nums[i - 1]);
        }

        return Math.max(max, maxValue[length]);
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(rob(nums));
    }
}
