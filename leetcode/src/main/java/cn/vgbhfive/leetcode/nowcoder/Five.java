package cn.vgbhfive.leetcode.nowcoder;

public class Five {

    /**
     * 5.二叉树根节点到叶子节点的所有路径和
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(process(node1));
    }

    public static int process(TreeNode node) {
        return dfs(node, 0);
    }

    /**
     * 递归
     * @param node
     * @param val
     * @return
     */
    private static int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int sum = 10 * val + node.val;
        if (node.left == null && node.right == null) {
            // 左右子节点均为 null
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

}
