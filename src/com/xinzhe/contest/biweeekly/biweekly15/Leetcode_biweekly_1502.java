package com.xinzhe.contest.biweeekly.biweekly15;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/6
 * Title : 1288. 删除被覆盖区间
 * Description : 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * link : https://leetcode-cn.com/problems/remove-covered-intervals
 * Level : Medium
 * Comment 15双周赛02
 */

public class Leetcode_biweekly_1502 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[0] >= intervals[i][0] && cur[1] >= intervals[i][0]) {
                n--;
            } else {
                cur = intervals[i];
            }
        }
        return n;
    }

}
