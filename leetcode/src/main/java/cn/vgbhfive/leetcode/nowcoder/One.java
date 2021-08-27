package cn.vgbhfive.leetcode.nowcoder;

public class One {

    /**
     * 1.大数加法
     * @param args
     */
    public static void main(String[] args) {
        String[] s1 = new String[]{
                "1", "2", "999999999999999999999"
        };
        String[] s2 = new String[]{
                "99", "89", "1111111111"
        };

        for (int i = 0; i < s1.length; i++) {
            System.out.println(process(s1[i], s2[i]));
        }
    }

    /**
     * 逐个解析字符串的字符,进行计算
     * @param s1
     * @param s2
     * @return
     */
    public static String process(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m == 0 || n == 0) {
            return n == 0 ? s1 : s2;
        }

        StringBuilder buffer = new StringBuilder();
        int i = m-1, j = n-1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? s1.charAt(i--) - '0' : 0;
            carry += j >= 0 ? s2.charAt(j--) - '0' : 0;
            buffer.append(carry%10);
            carry /= 10;
        }

        return buffer.reverse().toString();
    }

}
