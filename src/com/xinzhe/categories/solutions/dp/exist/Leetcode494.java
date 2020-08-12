package com.xinzhe.categories.solutions.dp.exist;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/27 19:55
 * Title : 494. 目标和
 * Description : 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * link : https://leetcode-cn.com/problems/target-sum
 * Level : Medium
 * Comment : related problem leetcode416
 */

//todo need to review, also can be resolved by dfs;
public class Leetcode494 {
    public int findTargetSumWays(int[] nums, int sum) {
        int m = nums.length;
        if(m == 0) return 0;
        int curSum = Arrays.stream(nums).sum();
        if(curSum < Math.abs(sum)) return 0;
        int n = curSum * 2 + 1;

        //dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        // n = sum * 2 + 1;
        int[][] dp = new int[m+1][n];

        dp[0][curSum]=1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(j + nums[i-1] < n){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
                if(j - nums[i-1] >= 0){
                    dp[i][j] += dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[m][curSum + sum];
    }
}
