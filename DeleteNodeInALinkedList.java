package leetcode;

/**
 * Created by tech4 on 2015/7/16.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.next = null;
    }
}
