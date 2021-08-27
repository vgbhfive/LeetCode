package cn.vgbhfive.leetcode.nowcoder;

public class Six {

    /**
     * 6.二叉树的最大路径和
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

    static int max = Integer.MIN_VALUE;
    public static int process(TreeNode node) {
        dfs(node);
        return max;
    }

    /**
     * 当前节点会出现以下状态的最大值：
     * 1、左子树
     * 2、右子树
     * 3、根节点加左子树（右子树为负值）
     * 4、根节点加右子树（左子树为负值）
     * 5、根节点（左右子树均为负值）
     * @param node
     * @return
     */
    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 左子树的最大路径和 -> 根节点加左子树 / 左子树
        int left = Math.max(0, dfs(node.left));
        // 右子树的最大路径和 -> 根节点加右子树 / 右子树
        int right = Math.max(0, dfs(node.right));
        // 当前节点的最大路径和
        max = Math.max(max, left + right + node.val);
        // 返回当前节点值或左右子树的最大值
        return Math.max(node.val, node.val + Math.max(left, right));
    }

}
