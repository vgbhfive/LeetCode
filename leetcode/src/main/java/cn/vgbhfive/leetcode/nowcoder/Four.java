package cn.vgbhfive.leetcode.nowcoder;

/**
 * @author Vgbh
 * @date 2021/8/10 23:19
 */
public class Four {

    /**
     * 4.判断链表中是否存在环
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
//        node6.next = node3;

        System.out.println(check(node1));

    }

    /**
     * 快慢指针
     * 如果在链表中出现环即快慢指针一定会相遇。
     * @param node
     * @return
     */
    public static boolean check(ListNode node) {
        if (node == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
