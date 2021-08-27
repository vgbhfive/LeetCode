package cn.vgbhfive.leetcode.nowcoder;

import java.util.Arrays;

public class Eleven {

    /**
     * 11.将升序数组转化为平衡二叉搜索树
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {3, 6, 10, 15},
                {-1, 0, 1, 2}
        };

        for (int i = 0; i < nums.length; i++) {
            TreeNode.print(process(nums[i]));
        }
    }

    /**
     * 数组有序即按照中序遍历的方式取出对应的根节点，再递归处理即可
     * @param nums
     * @return
     */
    public static TreeNode process(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        int mid = n / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(Arrays.copyOfRange(nums, 0, mid));
        node.right = process(Arrays.copyOfRange(nums, mid+1, n));
        return node;
    }

}
