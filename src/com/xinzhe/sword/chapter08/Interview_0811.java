package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.11. 硬币
 * Description : 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * link : https://leetcode-cn.com/problems/coin-lcci/
 * Level : Medium
 */
public class Interview_0811 {
    public static void main(String[] args) {
        Interview_0811 lc = new Interview_0811();
    }
    public int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = (int)1e9 + 7;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i-coin]) % mod;
            }
        }
        return dp[n];
    }
}
