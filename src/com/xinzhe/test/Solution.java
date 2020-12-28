package com.xinzhe.test;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {9,1,2,3,9};
        Solution so = new Solution();
        System.out.println(so.largestSumOfAverages(arr, 3));
    }
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
