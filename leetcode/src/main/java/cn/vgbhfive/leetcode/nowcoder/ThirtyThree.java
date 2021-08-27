package cn.vgbhfive.leetcode.nowcoder;

public class ThirtyThree {

    /**
     * 33.合并两个排序的链表
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode.print(process(node1, node2));

    }

    public static ListNode process(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        ListNode t1 = node1;
        ListNode t2 = node2;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if (t2 != null) {
            temp.next = t2;
        }
        if (t1 != null) {
            temp.next = t1;
        }

        return head.next;
    }

}
