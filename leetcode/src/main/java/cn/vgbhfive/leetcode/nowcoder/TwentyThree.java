package cn.vgbhfive.leetcode.nowcoder;

public class TwentyThree {

    /**
     * 23.划分链表
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node21 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node21;

        ListNode.print(process(node1, 3));

    }

    /**
     * 将小于 x 的节点重新排列，大于等于的节点也重新排列，随后合并两个链表即可
     * @param node
     * @param x
     * @return
     */
    public static ListNode process(ListNode node, int x) {
        ListNode temp1 = new ListNode(-1);
        ListNode temp2 = new ListNode(-1);
        ListNode p = temp1;
        ListNode q = temp2;

        ListNode temp = node;
        while (temp != null) {
            if (temp.val < x) {
                p.next = temp;
                p = temp;
            } else {
                q.next = temp;
                q = temp;
            }
            temp = temp.next;
        }
        q.next = null;
        p.next = temp2.next;
        return temp1.next;
    }


}
