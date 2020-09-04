package com.xinzhe.categories.solutions.dp.knapsack.knapsack01;

/**
 * @author Xin
 * @date 2020/3/20 18:31
 * Title : 474. 一和零
 * Description : 在计算机界中，我们总是追求用有限的资源获取最大的收益。
 *              现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
 *              你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
 * link : https://leetcode-cn.com/problems/ones-and-zeroes/
 * Level : Medium
 */
// 01背包问题
public class Leetcode474 {
    //三维数组
    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m+1][n+1];
        for(int k=1; k<=len; k++) {
            int[] count = helper(strs[k-1]);
            int c0 = count[0];
            int c1 = count[1];
            for(int i=0; i<=m; i++) {
                for(int j=0; j<=n; j++) {
                    dp[k][i][j] = dp[k-1][i][j];
                    if(c0 <= i && c1 <= j) dp[k][i][j] = Math.max(dp[k-1][i - c0][j - c1] + 1, dp[k-1][i][j]);
                }
            }
        }
        return dp[len][m][n];

    }

    //压缩空间
    public int findMaxForm(String[] strs, int m, int n) {
        if (m == 0 && n == 0) return 0;
        if (strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = helper(str);
            int c0 = count[0];
            int c1 = count[1];
            for (int i = m; i >= c0; i--) {
                for (int j = n; j >= c1; j--) {
                    dp[i][j] = Math.max(dp[i - c0][j - c1] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] helper(String s) {
        int c0 = 0;
        int c1 = 0;
        int[] source = new int[2];

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '0') {
                c0++;
            } else {
                c1++;
            }
        }
        source[0] = c0;
        source[1] = c1;
        return source;
    }
}