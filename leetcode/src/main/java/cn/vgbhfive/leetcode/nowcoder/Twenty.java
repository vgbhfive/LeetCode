package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class Twenty {

    /**
     * 20.数字字符串转化成IP地址
     * @param args
     */
    public static void main(String[] args) {
        String[] s = new String[]{
                "1002001271",
                "127001",
                "254001",
                "1111"
        };

        for (int i = 0; i < s.length; i++) {
            Utils.printL(process(s[i]));
        }
    }

    /**
     * 回溯法
     * @param x
     * @return
     */
    public static List<String> process(String x) {
        List<String> ans = new ArrayList<>();
        if (x.length() == 0) {
            return ans;
        }
        backtrack(x, 0, 3, ans);
        return ans;
    }

    /**
     *
     * @param x
     * @param start point 起始位置
     * @param cnt point 个数
     * @param ans
     */
    private static void backtrack(String x, int start, int cnt, List<String> ans) {
        if (cnt == 0) {
            // 按照 . 拆分 ip 字符串，然后检查其中的合法性
            String[] xs = x.split("\\.");
            if (xs.length < 4) {
                return;
            }
            for (String s : xs) {
                if (s.length() > 1 && s.charAt(0) == '0') {
                    return;
                }
                if (Integer.valueOf(s) > 255) {
                    return;
                }
            }
            ans.add(x);
            return;
        }
        int n = x.length();
        if (start >= n) {
            return;
        }
        // 间隔一位、两位、三位插入 point
        backtrack(x.substring(0, start+1) + '.' + x.substring(start+1, n), start+2, cnt-1, ans);
        if (start < n-2) {
            backtrack(x.substring(0, start+2) + '.' + x.substring(start+2, n), start+3, cnt-1, ans);
        }
        if (start < n-3) {
            backtrack(x.substring(0, start+3) + '.' + x.substring(start+3, n), start+4, cnt-1, ans);
        }
    }

}

