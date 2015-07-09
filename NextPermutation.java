package leetcode;

import java.util.Arrays;

/**
 * Created by tech4 on 2015/6/29.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int originalIndex = 0;
        int insteadIndex = 0;
        boolean isDescending = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDescending = false;
                originalIndex = i - 1;
                insteadIndex = i;
            }
            if (!isDescending && nums[i] > nums[originalIndex] && nums[i] < nums[insteadIndex]) {
                insteadIndex = i;
            }
        }

        int tmp;
        if (isDescending) {
            int i = 0;
            while (i < nums.length - i - 1) {
                tmp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = tmp;
                i++;
            }
        } else {
            tmp = nums[originalIndex];
            nums[originalIndex] = nums[insteadIndex];
            nums[insteadIndex] = tmp;
            qSort(nums, originalIndex + 1, nums.length - 1);
        }
    }

    private void qSort(int[] nums, int a, int b) {
        if (a >= b) return;

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
//        Random rnd = new Random(47);
//
//        int[] nums = new int[10];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = rnd.nextInt(10) + 1;
//        }
        int[] nums = {1, 5, 1};
        System.out.println(Arrays.toString(nums));

        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
