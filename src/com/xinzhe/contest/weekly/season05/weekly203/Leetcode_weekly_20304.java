package com.xinzhe.contest.weekly.season05.weekly203;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1563. 石子游戏 V
 * Description : 几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。
 *              游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；
 *              Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。
 *              如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。
 *
 * 返回 Alice 能够获得的最大分数 。
 * link : https://leetcode-cn.com/problems/stone-game-v
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_20304 {
    public static void main(String[] args) {
        Leetcode_weekly_20304 lc = new Leetcode_weekly_20304();
    }

    int[][] dp;
    int[] values;
    int n;
    public int stoneGameV(int[] stoneValue) {
        this.n = stoneValue.length;
        this.values = new int[n+1];
        this.dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            values[i+1] = values[i] + stoneValue[i];
        }
        return solve(stoneValue, 0, n-1);
    }

    private int solve(int[] stoneValue, int s, int e) {
        if(s == e) return 0;
        if(dp[s][e] != 0) return dp[s][e];
        int res = 0;
        for (int i = s; i < e; ++i) {
            int left = values[i+1] - values[s];
            int right = values[e+1] - values[i+1];

            int tmp;
            if(left > right) {
                tmp = right + solve(stoneValue, i+1, e);
            } else if(right > left) {
                tmp = left + solve(stoneValue, s, i);
            } else  {
                tmp = Math.max(right + solve(stoneValue, i+1, e), left + solve(stoneValue, s, i));
            }
            res = Math.max(tmp, res);
        }
        dp[s][e] = res;
        return res;
    }
}
