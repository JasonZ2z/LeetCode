package com.xinzhe.categories.solutions.dp.interval;

/**
 * @author Xin
 * @date 2020/12/15
 * Title : 813. 最大平均值和的分组
 * Description : 我们将给定的数组A分成K个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。
 *              注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * link : https://leetcode-cn.com/problems/largest-sum-of-averages
 * Level : Medium
 */
//todo need to review
public class Leetcode813 {
    Double[][][] dp;
    int[] arr;
    int[] pre;
    public double largestSumOfAverages(int[] arr, int k) {
        int n = arr.length;
        this.arr = arr;
        this.pre = new int[n+1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + arr[i-1];
        this.dp = new Double[n][n][k+1];
        return solve(0, n-1, k);
    }

    private double solve(int i, int j, int x) {
        if(x == 0 || i > j || x > j - i + 1) return 0;
        if(dp[i][j][x] != null) return dp[i][j][x];
        double ans = 0;
        if(x == 1) {
            ans = (pre[j+1] - pre[i]) * 1.0/(j - i + 1);
        } else  {
            for (int k = 1; k <= j - i - x + 2; ++k) {
                int p = i + k - 1;
                ans = Math.max(ans, solve(i, p, 1) + solve(p+1, j, x - 1));
            }
        }
        dp[i][j][x] = ans;
        return ans;
    }
}
