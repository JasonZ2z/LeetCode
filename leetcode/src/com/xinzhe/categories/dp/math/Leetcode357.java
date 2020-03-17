package com.xinzhe.categories.dp.math;

/**
 * @Author Xin
 * @create 2020/3/17 18:51
 * Title : 357. 计算各个位数不同的数字个数
 * Description : 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * link : https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * Level : Medium
 */
public class Leetcode357 {
    public static void main(String[] args) {
        System.out.println(Math.pow(10,2));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if( n == 1) return 9;
        if( n == 2) return 81;

        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] = 9;
        int sum = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] * (11 - i);
            sum += dp[i];
        }
        return sum;
    }
}
