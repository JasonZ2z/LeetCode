package com.xinzhe.categories.dp.math;


/**
 * @Author Xin
 * @create 2020/3/17 18:11
 * Title : 279. 完全平方数
 * Description : 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * link : https://leetcode-cn.com/problems/perfect-squares/
 * Level : Medium
 */

public class Leetcode279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    public static int numSquares(int n) {
        if(helper(n)) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            if(helper(i)) {
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i-1] +1;
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.min(dp[j]+dp[i-j], dp[i]);
            }

        }
        return dp[n];
    }

    private static boolean helper(int n){
        int res = (int)Math.sqrt(n);
        return res * res == n;
    }
}
