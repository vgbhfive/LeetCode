package cn.vgbhfive.leetcode.nowcoder;

public class Ninteen {

    /**
     * 19.子数组的最大累加和问题
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, -2, 3, 5, -2, 6, -1}
        };

        for (int i = 0; i < a.length; i++) {
            System.out.println(process(a[i]));
        }
    }

    /**
     * 动态规划
     * dp[i] 数组前 i 个元素中最大的子序列和
     * @param nums
     * @return
     */
    public static int process(int[] nums) {
        int n = nums.length;
        // 全局子序列和最大值
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
