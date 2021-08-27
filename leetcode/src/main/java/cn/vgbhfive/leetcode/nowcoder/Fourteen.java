package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fourteen {

    /**
     * 14.按之字形顺序打印二叉树
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

        Utils.printI(process(node5));

    }

    /**
     * 广度优先遍历 + 保存层数用于计算之字形
     * @param node
     * @return
     */
    public static List<List<Integer>> process(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.poll();
                if (level % 2 == 0) {
                    list.add(next.val);
                } else {
                    list.add(0, next.val);
                }
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
            }
            level++;
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }

}
