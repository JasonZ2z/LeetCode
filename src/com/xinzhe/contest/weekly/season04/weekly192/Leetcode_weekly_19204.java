package com.xinzhe.contest.weekly.season04.weekly192;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/7
 * Title :
 * Description :
 * link :
 * Level : Hard
 * Comment 192周赛04
 */
//todo
public class Leetcode_weekly_19204 {
    int inf = (int) 1e9;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], inf);
            }
        }
        dp[0][0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= target; k++) {
                    if (houses[i - 1] != 0 && houses[i - 1] != j) {
                        continue;
                    }
                    int c = cost[i - 1][j - 1];
                    if (houses[i - 1] != 0) {
                        c = 0;
                    }
                    //same
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + c);
                    for (int t = 0; t <= n && k > 0; t++) {
                        if (t == j) {
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][t][k - 1] + c);
                    }
                }
            }
        }

        int ans = inf;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m][i][target]);
        }

        //System.out.println(Arrays.deepToString(dp));
        if (ans >= inf) {
            return -1;
        }
        return ans;
    }

    public int minCost2(int[] houses, int[][] p, int n, int m, int k) {
        int[] c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            c[i + 1] = houses[i];
        }
        c[0] = -1;
        long[][][] dp = new long[n + 1][m][n + 5];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n + 5; l++) {
                    dp[i][j][l] = (long) 1e16;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            dp[0][i][1] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (c[i] == 0) {
                for (int j = 0; j < m; j++) {
                    for (int ka = 0; ka < n + 4; ka++) {
                        for (int l = 0; l < m; l++) {
                            if (l == j || i == 1) {
                                dp[i][l][ka] = Math.min(dp[i - 1][j][ka] + p[i - 1][l], dp[i][l][ka]);
                            } else {
                                dp[i][l][ka + 1] = Math.min(dp[i - 1][j][ka] + p[i - 1][l], dp[i][l][ka + 1]);
                            }
                        }
                    }
                }
            } else {
                for (int j = 0; j < m; j++) {
                    for (int ka = 0; ka < n + 4; ka++) {
                        if (c[i] - 1 == j || i == 1) {
                            dp[i][c[i] - 1][ka] = Math.min(dp[i - 1][j][ka], dp[i][c[i] - 1][ka]);
                        } else {
                            dp[i][c[i] - 1][ka + 1] = Math.min(dp[i - 1][j][ka], dp[i][c[i] - 1][ka + 1]);
                        }
                    }
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n][j][k]);
        }
        return (int) (ans == (long) 1e16 ? -1 : ans);
    }


}
