package cn.vgbhfive.leetcode.nowcoder;

public class ThirtyFour {

    /**
     * 34.求路径
     * 从 [0,0] 到达 [m,n] 的所有路径数量，其中只允许向下和向右
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{2, 2};
        int[] b = new int[]{1, 2};

        for (int i = 0; i < a.length; i++) {
            System.out.println(process(a[i], b[i]));
        }
    }

    public static int process(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
