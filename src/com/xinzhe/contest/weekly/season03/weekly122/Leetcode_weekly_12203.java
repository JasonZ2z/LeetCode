package com.xinzhe.contest.weekly.season03.weekly122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/25
 * Title : 986. 区间列表的交集
 * Description : 给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。返回这两个区间列表的交集。
 * link : https://leetcode-cn.com/problems/interval-list-intersections/
 * Level : Medium
 */

public class Leetcode_weekly_12203 {
    public static void main(String[] args) {
        Leetcode_weekly_12203 lc = new Leetcode_weekly_12203();
        int[][] arr1 = {{17,20}};
        int[][] arr2 = {{2,3},{6,8},{12,14},{19,20}};
        System.out.println(Arrays.deepToString(lc.intervalIntersection(arr1, arr2)));
    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length, n = B.length;
        int p = 0, q = 0;
        List<int[]> list = new ArrayList<>();
        while(p < m && q < n) {
            if(A[p][1] < B[q][0]) p++;
            else if(A[p][0] > B[q][1]) q++;
            else {
                int[] tmp = new int[2];
                tmp[0] = Math.max(A[p][0], B[q][0]);
                tmp[1] = Math.min(A[p][1], B[q][1]);
                list.add(tmp);
                if(A[p][1] > B[q][1]) q++;
                else p++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
