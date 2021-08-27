package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Nine {

    /**
     * 9.二叉树中是否存在节点和为指定值的路径
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

        System.out.println(process(node5, 22));

        TreeNode node21 = new TreeNode(21);
        TreeNode node22 = new TreeNode(22);

        node21.left = node22;

        System.out.println(process(node21, 0));

    }

    /**
     * 深度优先遍历
     * @param node
     * @param target
     * @return
     */
    public static boolean process(TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && target == node.val) {
            // 题目要求根节点到叶子节点，且路径和为 target
            return true;
        } else {
            return process(node.left, target - node.val) || process(node.right, target - node.val);
        }
    }

}
