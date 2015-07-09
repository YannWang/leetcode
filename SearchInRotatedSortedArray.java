package leetcode;

/**
 * Created by tech4 on 2015/6/29.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == -1) {
            if (nums[0] == target) return 0;
            else return -1;
        }

        int pivot = 1;
        while (pivot < nums.length && nums[pivot] >= nums[pivot - 1]) pivot++;
        if (nums[0] == target) return 0;
        else if (nums[0] > target) return binarySearch(nums, pivot, nums.length - 1, target);
        else return binarySearch(nums, 0, pivot - 1, target);
    }

    private int binarySearch(int[] nums, int a, int b, int target) {
        if (a > b) return -1;
        if (nums[a] > target || nums[b] < target) return -1;

        int middle = (a + b) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[middle] > target) return binarySearch(nums, a, middle - 1, target);
        else return binarySearch(nums, middle + 1, b, target);
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        SearchInRotatedSortedArray sirsa = new SearchInRotatedSortedArray();
        System.out.println(sirsa.search(nums, 6));
        System.out.println(sirsa.search(nums, 3));
    }
}
