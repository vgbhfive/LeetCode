package cn.vgbhfive.leetcode.nowcoder;

public class Sixteen {

    /**
     * 16.判断二叉树是否对称
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node15 = new TreeNode(5);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode node25 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node5.left = node12;
        node5.right = node22;
        node12.left = node13;
        node12.right = node15;
        node22.left = node25;
        node22.right = node23;
//        node23.left = node6;

        System.out.println(process(node5));

    }

    public static boolean process(TreeNode node) {
        return check(node, node);
    }

    private static boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            // 两个节点均为null
            return true;
        }
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            // 其中一个节点为null，另一个非null
            return false;
        }
        // 判断左右子树和右左子树以及当前比较节点的属性值
        return node1.val == node2.val &&
                check(node1.left, node2.right) && check(node1.right, node2.left);
    }

}
