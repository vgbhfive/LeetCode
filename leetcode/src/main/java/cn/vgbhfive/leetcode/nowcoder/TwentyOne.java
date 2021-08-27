package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class TwentyOne {

    /**
     * 21.链表内指定区间反转
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

        ListNode.print(process(node1, 2, 4));
        ListNode.print(process(node1, 2, 4));

    }

    /**
     * 先找到需要翻转的节点，其中保存前一个节点，然后执行翻转操作即可
     * @param node
     * @param m
     * @param n
     * @return
     */
    public static ListNode process(ListNode node, int m, int n) {
        ListNode temp = new ListNode(-1);
        temp.next = node;

        ListNode pre = temp;
        ListNode start = node;
        for (int i = 1; i < m; i++) {
            pre = start;
            start = start.next;
        }

        for (int i = 0; i < n-m; i++) {
            ListNode t = start.next;
            start.next = t.next;
            t.next = pre.next;
            pre.next = t; // 更新下一个节点
        }

        return temp.next;
    }

}
