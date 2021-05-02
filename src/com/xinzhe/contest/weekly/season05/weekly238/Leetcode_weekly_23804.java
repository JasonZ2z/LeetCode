package com.xinzhe.contest.weekly.season05.weekly238;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/04/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
//todo undo
public class Leetcode_weekly_23804 {
    public static void main(String[] args) {
        Leetcode_weekly_23804 lc = new Leetcode_weekly_23804();

    }

    public int maxBuilding(int n, int[][] res) {
        if (res.length == 0) return n - 1;

        Arrays.sort(res, (o1, o2) -> o1[0] - o2[0]);
        res[0][1] = Math.min(res[0][1], res[0][0] - 1);
        for (int i = 1; i < res.length; i++) {
            res[i][1] = Math.min(res[i][1], res[i - 1][1] + res[i][0] - res[i - 1][0]);
        }
        for (int i = res.length - 2; i >= 0; i--) {
            res[i][1] = Math.min(res[i][1], res[i + 1][1] + res[i + 1][0] - res[i][0]);
        }

        int max = (res[0][0] + res[0][1]) / 2;
        for (int i = 1; i < res.length; i++) {
            int[] pre = res[i - 1];
            int[] cur = res[i];
            int curMax = (pre[1] + cur[1] + cur[0] - pre[0]) / 2;
            max = Math.max(max, curMax);
        }
        int[] last = res[res.length - 1];
        max = Math.max(max, last[1] + n - last[0]);

        return max;
    }
}
