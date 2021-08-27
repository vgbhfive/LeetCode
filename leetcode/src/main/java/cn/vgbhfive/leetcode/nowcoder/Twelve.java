package cn.vgbhfive.leetcode.nowcoder;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class Twelve {

    /**
     * 12.重建二叉树
     * @param args
     */
    public static void main(String[] args) {
        int[][] pre = new int[][]{
                {1, 2, 4, 7, 3, 5, 6, 8}
        };
        int[][] mid = new int[][]{
                {4, 7, 2, 1, 5, 3, 8, 6}
        };

        for (int i = 0; i < pre.length; i++) {
            TreeNode.print(process(pre[i], mid[i]));
        }
    }

    /**
     * 参考二叉树的前序遍历和中序遍历，首先求出对应的根节点后再递归处理对应的左右子节点即可
     * @param pre
     * @param mid
     * @return
     */
    public static TreeNode process(int[] pre, int[] mid) {
        int n = mid.length, m = pre.length;
        if (m == 0 || n == 0) {
            return null;
        }
        int x = pre[0], i = 0;
        for (; i < n; i++) {
            if (mid[i] == x) {
                break;
            }
        }

        TreeNode node = new TreeNode(x);
        node.left = process(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(mid, 0, i));
        node.right = process(Arrays.copyOfRange(pre, i+1, m), Arrays.copyOfRange(mid, i+1, n));

        return node;
    }

}
