package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class TwentySix {

    /**
     * 26.括号生成
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4};

        for (int i = 0; i < a.length; i++) {
            Utils.printL(process(a[i]));
        }
    }

    /**
     * 回溯法
     * 其中 left 和 right 分别代表 ( 和 ) 的数量
     * @param n
     * @return
     */
    public static List<String> process(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(n, ans, new StringBuffer(), 0, 0);
        return ans;
    }

    private static void backTrack(int n, List<String> ans, StringBuffer buffer, int left, int right) {
        if (left == n && right == n) {
            if (check(buffer.toString())) {
                ans.add(buffer.toString());
                return;
            }
        }
        if (left < n) {
            StringBuffer buffer1 = new StringBuffer(buffer.toString());
            backTrack(n, ans, buffer1.append("("),left+1, right);
        }
        if (right < n) {
            StringBuffer buffer2 = new StringBuffer(buffer.toString());
            backTrack(n, ans, buffer2.append(")"),left, right+1);
        }
    }

    /**
     * 检查括号序列是否合法
     * @param x
     * @return
     */
    private static boolean check(String x) {
        char[] cs = x.toCharArray();
        int n = x.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                cnt++;
            }
            if (cs[i] == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }

}
