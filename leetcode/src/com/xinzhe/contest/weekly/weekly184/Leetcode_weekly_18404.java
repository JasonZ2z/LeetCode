package com.xinzhe.contest.weekly.weekly184;

/**
 * @Author Xin
 * @create 2020/4/12 10:10
 * Title : 5383. 给 N x 3 网格图涂色的方案数
 * Description : 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 *              给你网格图的行数 n 。请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
 * link : https://leetcode-cn.com/problems/number-of-ways-to-paint-n-x-3-grid
 * Level : Hard
 */
public class Leetcode_weekly_18404 {
    public static void main(String[] args) {
        System.out.println(numOfWays2(500));
    }

    public static int numOfWays2(int n) {
        int mod = 1000000007;
        long[] dp2 = new long[n + 1];
        long[] dp3 = new long[n + 1];
        dp2[1] = 6;
        dp3[1] = 6;

        for(int i = 2; i <= n; i++) {
            dp2[i] = (dp2[i - 1] * 3 + dp3[i - 1] * 2) % mod;
            dp3[i] = (dp2[i - 1] * 2 + dp3[i - 1] * 2) % mod;
        }
        return (int)(dp2[n] + dp3[n]) % mod;
    }
}
