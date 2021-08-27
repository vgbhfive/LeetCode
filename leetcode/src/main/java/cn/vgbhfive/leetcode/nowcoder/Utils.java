package cn.vgbhfive.leetcode.nowcoder;

import java.util.List;

public class Utils {

    public static void print(int[] nums) {
        for (Integer x : nums) {
            System.out.print(x + " -> ");
        }
        System.out.println();
    }

    public static void print(int[][] nums) {
        for (int[] x : nums) {
            for (int i : x) {
                System.out.print(i + " -> ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(List<List<TreeNode>> ans) {
        for (List<TreeNode> lists : ans) {
            for (TreeNode node : lists) {
                System.out.print(node.val + " -> ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printI(List<List<Integer>> ans) {
        for (List<Integer> lists : ans) {
            for (Integer x : lists) {
                System.out.print(x + " -> ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printN(List<int[]> ans) {
        for (int[] nums : ans) {
            for (Integer x : nums) {
                System.out.print(x + " -> ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printL(List<String> list) {
        for (String x : list) {
            System.out.print(x + " -> ");
        }
        System.out.println();
    }

}
