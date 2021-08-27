package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Eight {

    /**
     * 8.二叉树根节点到叶子节点和为指定值的路径
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

        Utils.print(process(node5, 22));
    }

    public static List<List<TreeNode>> process(TreeNode node, int target) {
        List<List<TreeNode>> ans = new ArrayList<>();
        List<TreeNode> lists = new ArrayList<>();
        dfs(node, target, ans, lists);
        return ans;
    }

    /**
     * 深度优先遍历
     * @param node
     * @param target
     * @param ans
     * @param lists
     */
    private static void dfs(TreeNode node, int target, List<List<TreeNode>> ans, List<TreeNode> lists) {
        if (node == null) {
            return;
        }
        List<TreeNode> temp1 = new ArrayList<>(lists);
        temp1.add(node);
        if (target - node.val == 0) {
            ans.add(new ArrayList<>(temp1));
            return;
        }
        dfs(node.left, target-node.val, ans, temp1);
        dfs(node.right, target-node.val, ans, temp1);
    }

}
