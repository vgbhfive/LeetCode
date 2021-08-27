package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.List;

public class TwentySeven {

    /**
     * 27.集合的所有子集
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3},
                {1, 2}
        };

        for (int i = 0; i < a.length; i++) {
            Utils.printI(process(a[i]));
        }
    }

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public static List<List<Integer>> process(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lists = new ArrayList<>();

        backTrack2(ans, lists, 0, nums);
        return ans;
    }

    /**
     * 从下标 index 开始保存子集
     * @param ans
     * @param lists
     * @param index
     * @param nums
     */
    private static void backTrack(List<List<Integer>> ans, List<Integer> lists, int index, int[] nums) {
        ans.add(new ArrayList<>(lists));
        for (int i = index; i < nums.length; i++) {
            lists.add(nums[i]);
            backTrack(ans, lists, i+1, nums);
            lists.remove(lists.size()-1);
        }
    }

    /**
     * 数组中的每一个值都有选与不选两种结果
     * @param ans
     * @param lists
     * @param index
     * @param nums
     */
    private static void backTrack2(List<List<Integer>> ans, List<Integer> lists, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(lists));
            return;
        }
        backTrack2(ans, lists, index+1, nums);
        lists.add(nums[index]);
        backTrack2(ans, lists, index+1, nums);
        lists.remove(lists.size()-1);
    }

}
