package cn.vgbhfive.leetcode.nowcoder;

import java.util.Arrays;

public class Thirty {

    /**
     * 30.数组中未出现的最小正整数
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {-1, 2, 3, 4},
                {1, 2, 3, 4},
                {3, 5, 2, 1}
        };

        for (int i = 0; i < a.length; i++) {
            System.out.println(process(a[i]));
        }
    }

    public static int process(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ans) {
                ans++;
            }
        }

        return ans;
    }

}
