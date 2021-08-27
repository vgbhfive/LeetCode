package cn.vgbhfive.leetcode.nowcoder;

import java.util.HashMap;
import java.util.Map;

public class ThirtyOne {

    /**
     * 31.第一个只出现一次的字符
     * @param args
     */
    public static void main(String[] args) {
        String[] s = new String[]{
                "google",
                "baidu",
                "aabbcc"
        };

        for (int i = 0; i < s.length; i++) {
            System.out.println(process(s[i]));
        }
    }

    public static int process(String x) {
        int n = x.length();
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            maps.put(x.charAt(i), maps.getOrDefault(x.charAt(i), 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (maps.get(x.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
