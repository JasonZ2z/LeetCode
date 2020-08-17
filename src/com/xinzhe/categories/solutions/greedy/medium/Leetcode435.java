package com.xinzhe.categories.solutions.greedy.medium;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/17
 * Title : 435. 无重叠区间
 * Description : 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *              可以认为区间的终点总是大于它的起点。
 *              区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * link : https://leetcode-cn.com/problems/non-overlapping-intervals
 * Level : Medium
 */
public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] pre = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur =  intervals[i];
            if(cur[0]>= pre[0] && cur[0] < pre[1]) count++;
            else pre = cur;
        }
        return count;

    }
}
