package leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        if (k == 0) return;

        int[] corrNums = new int[len];
        for (int i = 0; i < k; i++) {
            corrNums[len - k + i] = nums[i];
        }
        for (int i = 0; i < len - k; i++) {
            corrNums[i] = nums[k + i];
        }
        nums = corrNums;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        RotateArray ra = new RotateArray();
        ra.rotate(nums, 1);
    }
}
