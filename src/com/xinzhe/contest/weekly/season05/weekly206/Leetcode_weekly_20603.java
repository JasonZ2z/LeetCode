package com.xinzhe.contest.weekly.season05.weekly206;

/**
 * @author Xin
 * @date 2020/9/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20603 {
    public static void main(String[] args) {
        Leetcode_weekly_20603 lc = new Leetcode_weekly_20603();
        int[][] arr = {{2,-3},{-17,-8},{13,8},{-17,-15}};
        System.out.println(lc.minCostConnectPoints(arr));

    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n == 1)return 0;
        boolean[] used = new boolean[n];
        int cost = 0;
        for (int i = 0; i < n; ++i) {
            if(used[i]) continue;
            used[i] = true;
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < n; ++j) {
                if(j == i) continue;
                int val = getV(points[i], points[j]);
                if(val < min) {
                    min = val;
                    index = j;
                }
            }
            cost += min;
            used[index] = true;
            System.out.println(i +  "          " + index + "        " + min);
        }
        return cost;

    }

    private int getV(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}
