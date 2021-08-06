package cn.vgbhfive.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vgbh
 * @date 2021/8/6 17:06
 */
public class EightHundredFourtySeven {

    /**
     * 847.访问所有节点的最短路径
     * @param args
     */
    public static void main(String[] args) {
        int[][][] a = new int[][][]{
                {
                        {1, 2, 3},
                        {0},
                        {0},
                        {0}
                },
                {
                        {1},
                        {0, 2, 4},
                        {1, 3, 4},
                        {2},
                        {1, 2}
                }
        };

        for (int i = 0; i < a.length; i++) {
            System.out.println(shortestPathLength(a[i]));
        }
    }

    /**
     * 状态压缩 + BFS
     * 由题意这是一个等权无向图，要求从一个点都没有访问过到所有点被访问的最短路径
     *
     * 状态压缩：
     * (000...0101) 代表编号为 0 和编号为 2 的节点已经被访问过，而编号为 1 的节点尚未被访问。
     * 使用位运算 a = (state >> x) & 1 ，来获取stats中第 x 位的二进制表示。
     * 如果 a 为 1 则表示编号为 x 的节点已经被访问，为 0 则未被访问。
     * 当我们需要标记编号为 x 的节点已经被访问的话，可以使用位运算 stats | (1 << x) 来实现标记。
     *
     * 时间复杂度：O(n^2 * 2^n)
     * 空间复杂度：O(n*2^n)
     * @param graph
     * @return
     */
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;

        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 可以从任意节点起步，先将起步节点状态更新，并设置距离为 0
        Deque<int[]> deque = new ArrayDeque<int[]>();
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            deque.add(new int[]{1 << i, i});
        }

        // 广度优先遍历 -> 点 u 能够到达点 x，更新距离并入队
        while (!deque.isEmpty()) {
            int[] next = deque.poll();
            int state = next[0], u = next[1], step = dist[state][u];
            if (state == mask - 1) {
                return step;
            }
            for (int x : graph[u]) {
                if (dist[state | (1 << x)][x] == Integer.MAX_VALUE) {
                    dist[state | (1 << x)][x] = step + 1;
                    deque.addLast(new int[]{state | (1 << x), x});
                }
            }
        }

        return -1;
    }

}
