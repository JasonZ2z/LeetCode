package com.xinzhe.contest.weekly.season04.weekly158;


/**
 * @Author Xin
 * @create 2020/7/15
 * Title : 1223. 掷骰子模拟
 * Description : 有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。
 *          现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。
 *          假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。
 * link : https://leetcode-cn.com/problems/dice-roll-simulation
 * Level : Medium
 */

public class Leetcode_weekly_15803 {
    //todo need to review
    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        Leetcode_weekly_15803 lc = new Leetcode_weekly_15803();
    }
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n][7][16];
        //init
        for (int i = 1; i <= 6; ++i) {
            dp[0][i][1] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= 6; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if(j != k) {
                        for (int l = 1; l <= rollMax[k - 1]; ++l) {
                            dp[i][j][1] += dp[i-1][k][l];
                            dp[i][j][1] %= MOD;
                        }
                    } else {
                        for (int l = 1; l < rollMax[k - 1]; ++l) {
                            dp[i][j][l+1] += dp[i-1][k][l];
                            dp[i][j][l+1] %= MOD;
                        }
                    }
                }

            }
        }
        int sum = 0;
        for (int i = 1; i < 7; ++i) {
            for (int t = 1; t <= rollMax[i-1]; ++t) {
                sum = (sum + dp[n - 1][i][t]) % MOD;
            }
        }
        return sum;
    }
}
