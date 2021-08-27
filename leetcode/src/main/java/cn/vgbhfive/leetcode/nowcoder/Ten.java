package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ten {

    /**
     * 10.大数乘法
     * @param args
     */
    public static void main(String[] args) {
        String[] s1 = new String[]{
                "2", "12", "9999999999"
        };
        String[] s2 = new String[]{
                "99", "44", "666666666"
        };

        for (int i = 0; i < s1.length; i++) {
            System.out.println(process(s1[i], s2[i]));
        }
    }

    /**
     * 模拟日常乘法计算方法即可
     * @param s1
     * @param s2
     * @return
     */
    public static String process(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        List<String> lists = new LinkedList<>();

        for (int i = m-1; i >= 0; i--) {
            int x = s1.charAt(i) - '0';
            StringBuffer buffer = new StringBuffer();
            int carry = 0;
            for (int j = n-1; j >= 0; j--) {
                int y = s2.charAt(j) - '0';
                carry = carry + x * y;
                buffer.append(carry%10);
                carry /= 10;
            }
            if (carry > 0) {
                buffer.append(carry);
            }
            buffer.reverse();
            for (int j = i; j < m-1; j++) {
                buffer.append(0);
            }
            lists.add(buffer.toString());
        }

        String ans = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            ans = add(ans, lists.get(i));
        }

        return ans;
    }

    private static String add(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        StringBuffer buffer = new StringBuffer();
        int i = m-1, j = n-1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            carry += i >= 0 ? s1.charAt(i--) - '0' : 0;
            carry += j >= 0 ? s2.charAt(j--) - '0' : 0;
            buffer.append(carry%10);
            carry /= 10;
        }

        return buffer.reverse().toString();
    }

}
