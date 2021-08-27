package cn.vgbhfive.leetcode.nowcoder;

public class Eighteen {

    /**
     * 18.顺时针旋转矩阵
     * @param args
     */
    public static void main(String[] args) {
        int[][][] a = new int[][][]{
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                }
        };

        for (int i = 0; i < a.length; i++) {
            Utils.print(process(a[i]));
        }
    }

    /**
     * 细心找出其中的规律即可
     * @param nums
     * @return
     */
    public static int[][] process(int[][] nums) {
        int n = nums.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = nums[j][n-1-i];
                nums[j][n-1-i] = nums[i][j];
                nums[i][j] = nums[n-1-j][i];
                nums[n-1-j][i] = nums[n-1-i][n-1-j];
                nums[n-1-i][n-1-j] = temp;
            }
        }

        return nums;
    }

}
