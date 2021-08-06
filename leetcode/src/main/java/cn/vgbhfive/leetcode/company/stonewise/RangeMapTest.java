package cn.vgbhfive.leetcode.company.stonewise;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * @author Vgbh
 * @date 2021/8/6 17:15
 */
public class RangeMapTest {

    /**
     * 前几天遇到的面试问题，面试官给了答案，这里主要是了解一下实现思路，不得不说 Google 的思想很厉害！
     *
     * 输入：
     * [1, 3] 2
     * [5, 8) 11
     * (15, 17) 20
     *
     * 输出：
     * 6 -> 11
     * [2, 7] -> 2, 11
     *
     * @param args
     */
    public static void main(String[] args) {
        RangeMap<Integer, Integer> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), 1);
        rangeMap.put(Range.open(11, 20), 2);
        System.out.println(rangeMap);

        System.out.println(rangeMap.get(4));
        System.out.println(rangeMap.subRangeMap(Range.open(5, 14)));
    }

}
