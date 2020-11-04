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
        if(newInterval == null) return intervals;
        List<int[]> res = new ArrayList<>();
        int l = newInterval[0], r = newInterval[1];
        boolean flag = false;
        for(int[] cur : intervals) {
            if(l > cur[1]) res.add(cur);
            else if(cur[0] > r) {
                if(flag) res.add(cur);
                else {
                    res.add(new int[]{l, r});
                    res.add(cur);
                    flag = true;
                }
            }else {
                l = Math.min(l, cur[0]);
                r = Math.max(r, cur[1]);
            }
        }
        if(!flag) res.add(new int[]{l, r});
        return res.toArray(new int[0][]);
    }
}
