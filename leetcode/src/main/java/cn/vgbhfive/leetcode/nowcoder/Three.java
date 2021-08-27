package cn.vgbhfive.leetcode.nowcoder;

public class Three {

    /**
     * 3.链表中环的入口结点
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
        node6.next = node3;

        System.out.println(process2(node1).val);
    }

    /**
     * 破坏链表中的节点，当遇到已被被破坏的节点时即环的入口节点
     * @param node
     * @return
     */
    public static ListNode process(ListNode node) {
        if (node == null) {
            return null;
        }
        while (node != null) {
            if (node.next == node) {
                return node;
            }
            ListNode temp = node.next;
            node.next = node;
            node = temp;
        }

        return null;
    }

    /**
     * 快慢指针
     * @param node
     * @return
     */
    public static ListNode process2(ListNode node) {
        if (node == null) {
            return null;
        }
        // 快慢指针找到相交的节点
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 从头节点开始与慢节点交会的点即环的入口节点
        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
