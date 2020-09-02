package com.xinzhe.order.day13;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/9/2
 * Title : 486. 预测赢家
 * Description : 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 *              每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *              给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 * link : https://leetcode-cn.com/problems/predict-the-winner
 * Level : Medium
 * tag : 记忆化递归， dp
 */

public class Leetcode486 {
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        Leetcode486 lc = new Leetcode486();
        System.out.println(lc.PredictTheWinner(arr));

    }
    //递归
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if(n == 1 || n % 2 == 0) return true;
        return first(nums, 0, n-1, 0, 0);
    }

    private boolean first(int[] nums, int left, int right, int s1, int s2) {
        if(left <= right) {
            return second(nums, left + 1, right, s1 + nums[left], s2) || second(nums, left, right - 1, s1 + nums[right], s2);
        } else {
            return s1 >= s2;
        }
    }

    private boolean second(int[] nums, int left, int right, int s1, int s2) {
        if(left <= right) {
            return first(nums, left + 1, right, s1, s2 + nums[left]) && first(nums, left, right - 1, s1, s2 + nums[right]);
        } else {
            return s1 >= s2;
        }
    }

    //记忆化递归
    int[][] dp;
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;
        this.dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfs(nums, 0, n-1) >= 0;
    }

    private int dfs(int[] nums, int i, int j) {
        if(i > j) return 0;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int left = nums[i] - dfs(nums, i+1, j);
        int right = nums[j] - dfs(nums, i, j-1);
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }

    //dp
    public boolean PredictTheWinner3(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        // dp[i][j]：作为先手，在区间 nums[i..j] 里进行选择可以获得的相对分数
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
