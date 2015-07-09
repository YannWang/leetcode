package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by tech4 on 2015/7/3.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        qSort(nums, 0, nums.length - 1);
    }

    private void qSort(int[] nums, int a, int b) {
        if (a >= b) {
            return;
        }
        int left = a;
        int right = b;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        qSort(nums, a, left - 1);
        qSort(nums, left + 1, b);
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = new int[15];
        Random rnd = new Random(47);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rnd.nextInt(3);
        }
        System.out.println(Arrays.toString(nums));
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = new int[0];
        sc.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

    }
}
