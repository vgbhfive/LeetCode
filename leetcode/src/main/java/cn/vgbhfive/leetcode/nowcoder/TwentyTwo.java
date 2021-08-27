package cn.vgbhfive.leetcode.nowcoder;

public class TwentyTwo {

    /**
     * 22.合并两个有序的数组
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {4, 5, 6, 0, 0, 0}
        };
        int[][] b = new int[][]{
                {1, 2, 3}
        };
        int[] c = new int[]{3};
        int[] d = new int[]{3};

        for (int i = 0; i < a.length; i++) {
            Utils.print(process(a[i], b[i], c[i], d[i]));
        }
    }

    /**
     * 这里需要注意的是需要从大到小排序，因为有可能覆盖 nums1 中原有的值
     * @param nums1
     * @param nums2
     * @param m
     * @param n
     * @return
     */
    public static int[] process(int[] nums1, int[] nums2, int m , int n) {
        int max = m+n-1, i = m-1, j = n-1;
        while (i >= 0 && j >= 0) {
            nums1[max--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[max--] = nums2[i--];
        }
        while (j >= 0) {
            nums1[max--] = nums2[j--];
        }

        return nums1;
    }

}
