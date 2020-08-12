package com.xinzhe.order.day03;

/**
 * @author Xin
 * @date 2020/2/28 10:16
 * Title : 96. 不同的二叉搜索树
 * Description : 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * link : https://leetcode-cn.com/problems/unique-binary-search-trees/
 * Level : Medium
 */
public class Leetcode096 {

    public static void main(String[] args) {
        System.out.println(numTrees(2));
    }
    /**
     * 输出个数，纯数学问题：
     *      dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2] + ... + dp[n-1]*dp[0]
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i ; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
