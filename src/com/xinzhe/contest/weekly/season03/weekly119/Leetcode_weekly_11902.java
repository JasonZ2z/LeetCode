package com.xinzhe.contest.weekly.season03.weekly119;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 976. 三角形的最大周长
 * Description : 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回 0。
 * link : https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * Level : Easy
 */

public class Leetcode_weekly_11902 {
    public static void main(String[] args) {
        Leetcode_weekly_11902 lc = new Leetcode_weekly_11902();
    }

    public int largestPerimeter(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for(int i = n-1; i >= 2; --i) {
            if(arr[i-1] + arr[i-2] > arr[i]) {
                return arr[i-1] + arr[i-2] + arr[i];
            }
        }
        return 0;
    }
}
