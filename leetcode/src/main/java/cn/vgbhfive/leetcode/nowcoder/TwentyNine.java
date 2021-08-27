package cn.vgbhfive.leetcode.nowcoder;

public class TwentyNine {

    /**
     * 29.二维数组中的查找
     * @param args
     */
    public static void main(String[] args) {
        int[][][] a = new int[][][]{
                {
                        {1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}
                },
                {
                        {1, 2, 8},
                        {2, 4, 9},
                        {4, 7, 10},
                        {6, 8, 11}
                },
        };
        int[] b = new int[]{7, 3};

        for (int i = 0; i < a.length; i++) {
            System.out.println(process(a[i], b[i]));
        }
    }

    /**
     * 从左下角或者右上角作为起点，其为一个二叉树
     * @param nums
     * @param target
     * @return
     */
    public static boolean process(int[][] nums, int target) {
        int n = nums.length; // 行
        int m = nums[0].length; // 列

        int row = n-1, col = 0;
        while (row >= 0 && col < m) {
            if (nums[row][col] == target) {
                return true;
            }
            if (nums[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

}
