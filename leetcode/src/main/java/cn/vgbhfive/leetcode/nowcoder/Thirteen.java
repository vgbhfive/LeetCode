package cn.vgbhfive.leetcode.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

public class Thirteen {

    /**
     * 13.二叉树的最大深度
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(11);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);

        node5.left = node4;
        node5.right = node8;
        node4.left = node1;
        node4.right = node11;
        node8.right = node9;
        node11.left = node2;
        node11.right = node7;

        System.out.println(maxDepth(node5));

        TreeNode node12 = new TreeNode(12);
        TreeNode node17 = new TreeNode(17);
        TreeNode node18 = new TreeNode(18);

        node12.left = node17;
        node17.left = node18;

        System.out.println(maxDepth2(node12));

    }

    /**
     * 递归
     * @param node
     * @return
     */
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 广度优先遍历 BFS
     * @param node
     * @return
     */
    public static int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.poll();
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
            }
            level++;
        }
        return level;
    }

}
