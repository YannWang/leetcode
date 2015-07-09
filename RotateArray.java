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
        System.arraycopy(nums, 0, corrNums, len - k, k);
        System.arraycopy(nums, k, corrNums, 0, len - k);
        nums = corrNums;
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        RotateArray ra = new RotateArray();
        ra.rotate(nums, 1);
    }
}
