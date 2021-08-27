package cn.vgbhfive.leetcode.nowcoder;

public class ThirtyTwo {

    /**
     * 32.求平方根
     * @param args
     */
    public static void main(String[] args) {
        int[] n = new int[]{2, 4, 5};

        for (int i = 0; i < n.length; i++) {
            System.out.println(sqrt2(n[i]));
        }
    }

    public static int sqrt(int n) {
        return (int) Math.sqrt(n);
    }

    /**
     * 二分求解
     * @param n
     * @return
     */
    public static int sqrt2(int n) {
        int l = 0, r = n, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid <= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
