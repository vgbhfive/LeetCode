package cn.vgbhfive.leetcode.nowcoder;

public class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
