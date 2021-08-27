package cn.vgbhfive.leetcode.nowcoder;

public class TwentyEight {

    /**
     * 28.最小覆盖子串
     * @param args
     */
    public static void main(String[] args) {
        String[] s1 = new String[]{
                "abcdefghijklmn",
                "qqqqqqqqqqqqqqqqqq"
        };
        String[] s2 = new String[]{
                "ecf",
                "aa"
        };

        for (int i = 0; i < s1.length; i++) {
            System.out.println(process(s1[i], s2[i]));
        }
    }

    public static String process(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int l = 0, r = 0, cnt = m, min = n, left = Integer.MAX_VALUE;
        int[] nums2 = new int[26];
        // 记录待匹配字符串中元素出现的次数
        for (int i = 0; i < m; i++) {
            nums2[s2.charAt(i) - 'a']++;
        }

        while (r < n) {
            char c = s1.charAt(r);
            if (nums2[c - 'a'] > 0) {
                cnt--;
            }
            nums2[c - 'a']--;
            if (cnt == 0) {
                while (l < r && nums2[s1.charAt(l) - 'a'] < 0) {
                    nums2[s1.charAt(l) - 'a']++;
                    l++;
                }
                // 更新最短的子串长度和起始位置
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    left = l;
                }
                // 为下一次循环创建初始化条件
                nums2[s1.charAt(l) - 'a']++;
                l++;
                cnt++;
            }
            r++;
        }

        return min == n ? "" : s1.substring(left, left+min);
    }

}
