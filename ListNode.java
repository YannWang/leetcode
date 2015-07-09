package leetcode;

import java.util.Random;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode generateRandomList(int length, int range) {
        if (length == 0) {
            return null;
        }

        Random rnd = new Random();
        ListNode head = new ListNode(rnd.nextInt(range));
        if (length == 1) {
            return head;
        }
        ListNode cursor = head;
        for (int i = 0; i < length; i++) {
            cursor.next = new ListNode(rnd.nextInt(range));
            cursor = cursor.next;
        }

        return head;
    }

    public static ListNode generateSortedList(int length, int range) {
        int[] nums = new int[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            nums[i] = rnd.nextInt(range);
        }
        Sorting.quickSort(nums);

        ListNode list = fromArraysToListNode(nums);

        return list;
    }

    public static ListNode fromArraysToListNode(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        ListNode list = new ListNode(nums[0]);
        ListNode cursor = list;

        for (int i = 1; i < nums.length; i++) {
            cursor.next = new ListNode(nums[i]);
            cursor = cursor.next;
        }

        return list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cursor = this;
        while (cursor != null) {
            sb.append(cursor.val).append(", ");
            cursor = cursor.next;
        }

        return sb.toString().substring(0, sb.toString().length() - 2);
    }

}
