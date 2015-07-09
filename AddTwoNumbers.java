package leetcode;

import leetcode.ListNode;

public class AddTwoNumbers {
    //has problem, see function 2 and function 3
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }

        String sList1 = sb1.toString();
        String sList2 = sb2.toString();
        int len1 = sList1.length();
        int len2 = sList2.length();

        if (len1 == 0) {
            return l2;
        }
        if (len2 == 0) {
            return l1;
        }

        ListNode result = new ListNode(0);

        int i, j;
        int sum;
        int flag = 0;
        for (i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {
            sum = Integer.valueOf(sList1.substring(i, i + 1)) + Integer.valueOf(sList2.substring(j, j + 1)) + flag;
            flag = sum / 10;
            result = addNode(result, sum % 10);
        }
        for (; i >= 0; i--) {
            sum = Integer.valueOf(sList1.substring(i, i + 1)) + flag;
            flag = sum / 10;
            result = addNode(result, sum % 10);
        }
        for (; j >= 0; j--) {
            sum = Integer.valueOf(sList2.substring(j, j + 1)) + flag;
            flag = sum / 10;
            result = addNode(result, sum % 10);
        }

        return result.next;
    }

    public ListNode addNode(ListNode result, int val) {
        ListNode node = new ListNode(val);
        node.next = result.next;
        result.next = node;
        return result;
    }

    public ListNode addTwoNumbers2_enhanced(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = l1;
            l1 = l2;
            l2 = p1;
        }
        result = l1;


        int sum = 0;
        int flag = 0;
        while (p2.next != null) {
            sum = p1.val + p2.val + flag;
            l1.val = sum % 10;
            flag = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        flag += p2.val;
        while (p1.next != null) {
            sum = p1.val + flag;
            if (sum < 10) {
                flag = 0;
                p1.val = sum;
                break;
            }
            p1.val = sum % 10;
            flag = sum / 10;
            p1 = p1.next;
        }
        sum = p1.val + flag;
        if (sum >= 10) {
            p1.next = new ListNode(sum / 10);
            p1.val = sum % 10;
        }
        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int sum = 0;
        int flag = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1.next != null && p2.next != null) {
            sum = p1.val + p2.val + flag;
            flag = sum / 10;
            p1.val = sum % 10;
            p2.val = sum % 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        sum = p1.val + p2.val + flag;
        flag = sum / 10;
        p1.val = sum % 10;
        p2.val = sum % 10;
        //length of the two lists are equal
        if (p1.next == null && p2.next == null && flag == 1) {
            p1.next = new ListNode(1);
            return l1;
        }
        //length not equal
        p1 = p1.next;
        p2 = p2.next;
        //list1's length is larger than list2
        if (p1 != null) {
            p1 = remainList(p1, flag);
            return l1;
        }
        //list2's length is larger than list1
        p2 = remainList(p2, flag);
        return l2;
    }

    public ListNode remainList(ListNode p, int flag) {
        ListNode p1 = p;
        while (p1.val == 9 && flag == 1) {
            if (p1.next == null) {
                p1.val = 0;
                p1.next = new ListNode(1);
                return p;
            } else {
                p1.val = 0;
                flag = 1;
                p1 = p1.next;
            }
        }

        p1.val = p1.val + flag;
        return p;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode r = result;
        int sum = 0;
        int flag = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + flag;
            r.next = new ListNode(sum % 10);
            flag = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            r = r.next;
        }
        while (l1 != null) {
            sum = l1.val + flag;
            r.next = new ListNode(sum % 10);
            flag = sum / 10;
            l1 = l1.next;
            r = r.next;
        }
        while (l2 != null) {
            sum = l2.val + flag;
            r.next = new ListNode(sum % 10);
            flag = sum / 10;
            l2 = l2.next;
            r = r.next;
        }
        if (flag == 1) {
            r.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);


        ListNode result = new AddTwoNumbers().addTwoNumbers3(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
