package cn.vgbhfive.leetcode.nowcoder;

public class Two {

    /**
     * 2.重排链表
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5 => 0 -> 5 -> 1 -> 4 -> 2 -> 3
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode.print(process(node1));
    }

    /**
     * 快慢指针对链表进行切分，然后后面链表逆序，最后两个链表合并即可
     * @param node
     * @return
     */
    public static ListNode process(ListNode node) {
        // 找到中间节点
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        // 后面链表逆序
        ListNode pre = null;
        ListNode two = next;
        while (two != null) {
            // 记录下一个节点
            ListNode temp = two.next;
            two.next = pre;
            pre = two;
            two = temp;
        }

        // 链表重组
        ListNode head = node;
        while (pre != null) {
            ListNode temp = node.next;
            ListNode temp1 = pre.next;
            node.next = pre;
            pre.next = temp;
            node = temp;
            pre = temp1;
        }

        return head;
    }

}
