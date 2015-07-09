package leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by tech4 on 2015/6/25.
 */
public class MergeKSortedArray {
    public static ListNode mergeKLists(ListNode[] lists) {
        Set<Integer> indexOfListSet = new HashSet<>();
        for (int i = 0; i < lists.length; i++) {
            indexOfListSet.add(i);
        }
        ListNode head = new ListNode(0);
        int size = indexOfListSet.size();
        while (size != 0) {
            int min = Integer.MAX_VALUE;
            for (int i : indexOfListSet) {
                try {
                    if (lists[i].val < min) {
                        min = lists[i].val;
                        lists[i] = lists[i].next;
                    }
                } catch (NullPointerException ex) {
                    indexOfListSet.remove(i);
                }
            }
            head.next = new ListNode(min);
            size = indexOfListSet.size();
        }
        return head.next;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        ListNode[] lists = new ListNode[5];

        for (int i = 0; i < 5; i++) {
            lists[i] = ListNode.generateSortedList(rnd.nextInt(10), 100);
            System.out.println(lists[i]);
        }

        ListNode merged = mergeKLists(lists);
        System.out.println(merged);
    }
}
