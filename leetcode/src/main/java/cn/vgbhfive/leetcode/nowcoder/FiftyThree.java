package cn.vgbhfive.leetcode.nowcoder;

public class FiftyThree {

    /**
     * 53��ɾ������ĵ����� n ���ڵ�
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode.print(deleteN(node1, 5));
    }

    public static ListNode deleteN(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }

        ListNode pre = slow;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return head;
    }

}
