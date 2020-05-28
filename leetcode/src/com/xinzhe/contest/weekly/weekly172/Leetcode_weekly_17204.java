package com.xinzhe.contest.weekly.weekly172;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/23
 * Title : 1326. 灌溉花园的最少水龙头数目
 * Description : 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 *          花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 *          给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 *          请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-number-of-taps-to-open-to-water-a-garden
 * Level : Hard
 * Comment 172周赛04
 */

public class Leetcode_weekly_17204 {
    public int minTaps(int n, int[] ranges) {

        int[][] dp = new int[n + 1][2];

        for (int i = 0; i < n + 1; ++i) {
            dp[i][0] = ranges[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> b[0] - a[0]);
        //todo
        return 0;

    }

}
