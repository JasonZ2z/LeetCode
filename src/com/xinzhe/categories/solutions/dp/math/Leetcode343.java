package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/17 18:51
 * Title : 343. 整数拆分
 * Description : 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * link : https://leetcode-cn.com/problems/integer-break/
 * Level : Medium
 */
//todo need to review
public class Leetcode343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(4));
    }
    public static int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j],j) * (i-j));
            }
        }
        return dp[n];
    }
}
