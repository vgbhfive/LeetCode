package cn.vgbhfive.leetcode.company.bytedance;

public class ThirtySixBase {

    /**
     * 36.36进制
     * 1 + a = b / 1b + 2x = 48
     * @param args
     */
    public static void main(String[] args) {
        String[] s1 = new String[]{
                "1", "1b", "1", "zz"
        };
        String[] s2 = new String[]{
                "a", "2x", "2a", "a"
        };

        for (int i = 0; i < s1.length; i++) {
            System.out.println(process(s1[i], s2[i]));
        }
    }

    static char[] cs = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static String process(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int i = m-1, j = n-1, carry = 0;
        StringBuffer buffer = new StringBuffer();

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            if (x >= 49 && x <= 74) {
                x -= 39;
            }
            if (y >= 49 && y <= 74) {
                y -= 39;
            }
            int sum = x + y + carry;
            buffer.append(cs[sum%36]);
            carry = sum / 36;
            i--;
            j--;
        }

        return buffer.reverse().toString();
    }

}
