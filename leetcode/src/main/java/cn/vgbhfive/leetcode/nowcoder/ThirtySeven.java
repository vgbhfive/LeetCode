package cn.vgbhfive.leetcode.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ThirtySeven {

    /**
     * 37.合并区间
     * @param args
     */
    public static void main(String[] args) {
        int[][][] a = new int[][][]{
                {
                        {10, 30},
                        {20, 60},
                        {80, 100},
                        {120, 140}
                },
                {
                        {10, 40},
                        {20, 30},
                        {41, 55},
                }
        };

        for (int i = 0; i < a.length; i++) {
            Utils.printN(process(a[i]));
        }
    }

    /**
     * 小顶堆 + 比较聚合
     * @param nums
     * @return
     */
    public static List<int[]> process(int[][] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t0, int[] t1) {
                if (t0[0] == t1[0]) {
                    return t0[1] - t1[1];
                } else {
                    return t0[0] - t1[0];
                }
            }
        });

        List<int[]> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            queue.add(nums[i]);
        }

        ans.add(queue.poll());
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (ans.get(ans.size()-1)[1] > next[0]) {
                ans.get(ans.size()-1)[1] = Math.max(next[1], ans.get(ans.size()-1)[1]);
            } else {
                ans.add(next);
            }
        }

        return ans;
    }

}
