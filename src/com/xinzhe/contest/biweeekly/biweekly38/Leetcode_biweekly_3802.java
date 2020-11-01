package com.xinzhe.contest.biweeekly.biweekly38;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/31
 * Title :
 * Description :
 * link : 
 * Level : Easy
 */
public class Leetcode_biweekly_3802 {
    public static void main(String[] args) {

    }
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        int max = 0;
        int n = points.length;
        for (int i = 1; i < n; ++i) {
            max = Math.max(max, points[i][0] - points[i-1][0]);
        }
        return max;
    }
}
