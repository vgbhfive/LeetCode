package cn.vgbhfive.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * �������
     * @param node
     */
    public static void print(TreeNode node) {
        if (node == null) {
            System.out.println("node is null!");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.poll();
                if (next == null) {
                    System.out.print("# ");
                    continue;
                }
                queue.add(next.left);
                queue.add(next.right);
                System.out.print(next.val + " ");
            }
            System.out.println();
        }
    }

    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " -> ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
