package com.xinzhe.order.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/4/16
 * Title : 56. 合并区间
 * Description : 给出一个区间的集合，请合并所有重叠的区间。
 * link : https://leetcode-cn.com/problems/merge-intervals/
 * Level : Medium
 */

public class Leetcode056 {
    public static void main(String[] args) {
        //int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] arr = {{1,4},{0,5}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
    private static int[][] merge(int[][] intervals) {
        int m = intervals.length;
        if(m == 0) return new int[0][];
        if(m == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(s -> s[0]));
        List<int[]> list = new ArrayList<>();
        int preLeft =intervals[0][0] , preRight = intervals[0][1];
        int i = 1;
        while(i < m){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(preRight < left) {
                list.add(new int[]{preLeft, preRight});
                preLeft = left;
                preRight = right;
            } else if(right > preRight){
                preRight = right;
            }
            i++;
        }
        list.add(new int[]{preLeft, preRight});
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); ++j) {
            res[j] = list.get(j);
        }
        return res;
    }
}
