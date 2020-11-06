package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.01. 三步问题
 * Description : 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * link : https://leetcode-cn.com/problems/three-steps-problem-lcci
 * Level : Easy
 */
public class Interview_0801 {
    public int waysToStep(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=n; i++) {
            dp[i]= dp[i-1] + dp[i-2] + dp[i-3];
            dp[i] %= 1000000007;
        }
        return (int)dp[n];
    }
}
