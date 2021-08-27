package cn.vgbhfive.leetcode.nowcoder;

public class Seventeen {

    /**
     * 17.最长回文子串
     * @param args
     */
    public static void main(String[] args) {
        String[] s = new String[]{
                "abc1234321ab"
        };

        for (int i = 0; i < s.length; i++) {
            System.out.println(process(s[i]));
        }
    }

    /**
     * 动态规划
     * @param x
     * @return
     */
    public static int process(String x) {
        int n = x.length();
        if (n < 2) {
            return n;
        }

        char[] cs = x.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            // 长度为 1 的字符串均为 true
            dp[i][i] = true;
        }

        int ans = 1;
        // 长度
        for (int l = 2; l <= n; l++) {
            // 字符串起始坐标点
            for (int i = 0; i < n-l; i++) {
                // 字符串结束坐标点
                int j = i + l - 1;
                if (cs[i] == cs[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && (j-i+1) > ans) {
                    ans = j - i + 1;
                }
            }
        }

        return ans;
    }

}
