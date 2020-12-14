package com.xinzhe.contest.weekly.season05.weekly219;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/13
 * Title : 1690. 石子游戏 VII
 * Description : 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 *              有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 *              鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 *              给你一个整数数组stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 * link : https://leetcode-cn.com/problems/stone-game-vii
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_21903 {
    public static void main(String[] args) {
        Leetcode_weekly_21903 lc = new Leetcode_weekly_21903();
        int[] arr = {5,3,1,4,2};
        System.out.println(lc.stoneGameVII(arr));
    }

    Integer[][] dp;
    int[] stones;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        this.stones = stones;
        int sum = Arrays.stream(stones).sum();
        this.dp = new Integer[n][n];
        return solve(0, n-1, sum);
    }

    private int solve(int i, int j, int sum) {
        if(i == j) return 0;
        int res = 0;
        if(i < j) {
            if(dp[i][j] != null) return dp[i][j];
            res = Math.max(res, sum - stones[j] - solve(i, j-1, sum - stones[j]));
            res = Math.max(res, sum - stones[i] - solve(i+1, j, sum - stones[i]));
            dp[i][j] = res;
        }
        return res;
    }

    // 前缀和 + 区间DP
    public int stoneGameVII2(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        int[][] dp = new int[n][n];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + nums[i-1];
        for(int len = 2; len <= n; len++) {
            for(int i=0; i + len <= n; i++) {
                int j = i + len - 1;
                if(j == i+1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    dp[i][j] = Math.max(pre[j+1] - pre[i+1] - dp[i+1][j], pre[j] - pre[i] - dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
