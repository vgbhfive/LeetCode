package cn.vgbhfive.leetcode.nowcoder;

public class Seven {

    /**
     * 7.买卖股票的最好时机
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 4, 2},
                {2, 4, 1}
        };

        for (int i = 0; i < a.length; i++) {
            System.out.println(process(a[i]));
            System.out.println(process2(a[i]));
        }
    }

    public static int process(int[] nums) {
        int n = nums.length;
        // 从后往前计算最大值
        int[] maxs = new int[n];
        maxs[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxs[i] = Math.max(nums[i], maxs[i + 1]);
        }

        // 从前往后计算最小值和 max 的差
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxs[i] - nums[i]);
        }

        return max;
    }

    public static int process2(int[] nums) {
        int n = nums.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i] - min);
        }

        return max;
    }

    /**
     * 动态规划
     * dp[i][0]: 买。 dp[i][1]: 没买。
     * @param prices
     * @return
     */
    public int process3(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 动态规划优化
     */
    public int process4(int[] prices) {
        int one = 0;
        int two = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            one = Math.max(one, two + prices[i]);
            two = Math.max(two, -prices[i]);
        }

        return one;
    }

}
