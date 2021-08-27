package cn.vgbhfive.leetcode.nowcoder;

public class TwentyFour {

    /**
     * 24.删除有序链表中重复的元素-II
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node21 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node41 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node21;
        node21.next = node3;
        node3.next = node4;
        node4.next = node41;
        node41.next = node5;

        ListNode.print(node1);

        ListNode.print(process(node1));

    }

    /**
     * 创建临时头节点
     * 保存前置节点和当前节点，判断当前节点与下一个节点值是否相同，执行遍历删除操作
     * @param node
     * @return
     */
    public static ListNode process(ListNode node) {
        ListNode dummy = new ListNode(-1);
        dummy.next = node;
        ListNode pre = dummy;
        ListNode head = dummy.next;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int num = head.val;
                while (head.next != null && head.next.val == num) {
                    head.next = head.next.next;
                }
                pre.next = head.next;
            } else {
                pre = head;
                head = head.next;
            }
        }

        return dummy.next;
    }

}
