package com.xinzhe.categories.structure.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/14
 * Title : 57. 插入区间
 * Description : 给出一个无重叠的 ，按照区间起始端点排序的区间列表。在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * link : https://leetcode-cn.com/problems/insert-interval/
 * Level : Hard
 */

public class Leetcode057 {
    public static void main(String[] args) {
        Leetcode057 lc = new Leetcode057();
        int[][] nums = {{1,3},{6,9}};
        System.out.println(Arrays.deepToString(lc.insert(nums, new int[]{2, 5})));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s = newInterval[0], e = newInterval[1];
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < n && s > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }
        int[] tmp = new int[]{s, e};
        while (i < n && newInterval[1] >= intervals[i][0]) {
            tmp[0] = Math.min(tmp[0], intervals[i][0]);
            tmp[1] = Math.max(tmp[1], intervals[i][1]);
            i++;
        }
        res.add(tmp);
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
