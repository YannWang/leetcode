package leetcode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        int len = 0;
        ListNode p0 = head;
        ListNode p1 = head;
        while (p0 != null) {
            len++;
            p0 = p0.next;
            if (len % 2 == 0)
                p1 = p1.next;
        }
        if (len % 2 != 0) {
            p1 = p1.next;
        }

        //pointer to the first half from the beginning.
        ListNode pFirst = head;
        //reverse pointer to the second half from the end.
        ListNode pSecond = reverseList(p1);
        int i = 0;
        while (i < (len / 2) - 1) {
            p0 = pFirst;
            p1 = pSecond;
            pFirst = pFirst.next;
            pSecond = pSecond.next;
            i++;

            p1.next = pFirst;
            p0.next = p1;
        }

        if (len % 2 == 0) {
            pFirst.next = pSecond;
            pSecond.next = null;
        } else {
            pSecond.next = pFirst.next;
            pFirst.next = pSecond;
            pSecond.next.next = null;
        }
    }

    ListNode reverseList(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = node1.next;
        if (node2 == null) {
            return node1;
        }
        ListNode node3 = node2.next;
        if (node3 == null) {
            node2.next = node1;
            node1.next = null;
            return node2;
        }
        while (node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;
        head.next = null;

        return node2;
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();

        int num = 4;
        ListNode[] listArray = new ListNode[num];

        listArray[0] = new ListNode(1);
        for (int i = 1; i < num; i++) {
            listArray[i] = new ListNode(i + 1);
            listArray[i - 1].next = listArray[i];
        }

        ListNode head = listArray[0];
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();

        head = listArray[0];
        rl.reorderList(head);
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }
}
