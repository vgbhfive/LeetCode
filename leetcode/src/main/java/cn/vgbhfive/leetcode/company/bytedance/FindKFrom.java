package cn.vgbhfive.leetcode.company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vgbh
 * @date 2021/8/6 16:47
 */
public class FindKFrom {

    /**
     * 求数组内部的某一个元素的索引，要求该值比左边元素都大但同时都比右边元素都小。
     * 输入：[2, 3, 1, 8, 9, 20, 12]
     * 输出：[3, 4]
     * 解释：数组中的 8，9 分别满足题目的要求，他们的索引分别为 3，4
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 3, 1, 8, 9, 20, 12}
        };

        for (int i = 0; i < a.length; i++) {
            print(process(a[i]));
        }
    }

    /**
     * 单调栈 -> 获取到某点前后的最大值和最小值
     * @param nums
     * @return
     */
    public static List<Integer> process(int[] nums) {
        int n = nums.length;
        // 从前往后获取当前位置上前面数组元素的最大值（不包括其自身）
        int[] maxV = new int[n];
        Arrays.fill(maxV, Integer.MIN_VALUE);
        for (int i = 1; i < n; i++) {
            maxV[i] = Math.max(nums[i-1], maxV[i-1]);
        }

        // 从后往前获取当前位置上后面数组元素的最小值（不包括其本身）
        int[] minV = new int[n];
        Arrays.fill(minV, Integer.MAX_VALUE);
        for (int i = n-2; i >= 0; i--) {
            minV[i] = Math.min(nums[i+1], minV[i+1]);
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxV[i] && nums[i] < minV[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void print(List<Integer> nums) {
        for (Integer x : nums) {
            System.out.print(x + " -> ");
        }
        System.out.println();
    }

}



