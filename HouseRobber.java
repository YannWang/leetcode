package leetcode;

public class HouseRobber {
    //actually this is dynamic programming, but the logic is too bad.
    //I will rewrite it later.
    public int rob(int[] num) {
        int max = 0;
        int size = num.length;
        if (size == 0) {
            return max;
        }

        int[] result = new int[size];
        result[0] = num[0];
        if (size > 1) {
            result[1] = max(num[0], num[1]);
        }
        if (size > 2) {
            int index = 2;
            while (index < size) {
                result[index] = max(result[index - 1], result[index - 2] + num[index]);
                index++;
            }
        }
        return result[size - 1];
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] maxValue = new int[length + 1];
        maxValue[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], maxValue[i - 2] + nums[i - 1]);
        }
        return maxValue[length];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 8, 2, 4, 9, 5, 6, 3, 0, 2, 4};
        int max = new HouseRobber().rob(nums);
        System.out.println(max);
        System.out.println(rob2(nums));
    }

}
