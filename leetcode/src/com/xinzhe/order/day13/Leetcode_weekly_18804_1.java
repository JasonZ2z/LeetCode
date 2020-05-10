package com.xinzhe.order.day13;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18804_1 {
    int mod = (int) (1e9 + 7);
    int[][] mat;
    int[][] rect;
    int n;
    int m;

    int[][][] dp;

    public int subregion(int l, int r, int t, int b) {
        int ans = rect[r][b];
        if (l > 0) {
            ans -= rect[l - 1][b];
        }
        if (t > 0) {
            ans -= rect[r][t - 1];
        }
        if (l > 0 && t > 0) {
            ans += rect[l - 1][t - 1];
        }
        return ans;
    }

    public int dp(int l, int t, int k) {
        if (dp[l][t][k] == -1) {
            if (k == 1) {
                return dp[l][t][k] = subregion(l, n - 1, t, m - 1) > 0 ? 1 : 0;
            }
            long ans = 0;
            //left
            for (int i = l; i < n - 1; i++) {
                if (subregion(l, i, t, m - 1) == 0) {
                    continue;
                }
                ans += dp(i + 1, t, k - 1);
            }
            //top
            for (int i = t; i < m - 1; i++) {
                if (subregion(l, n - 1, t, i) == 0) {
                    continue;
                }
                ans += dp(l, i + 1, k - 1);
            }

            dp[l][t][k] = (int) (ans % mod);
        }
        return dp[l][t][k];
    }

    public int ways2(String[] pizza, int k) {
        n = pizza.length;
        m = pizza[0].length();

        mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
            }
        }

        rect = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rect[i][j] = mat[i][j];
                if (j > 0) {
                    rect[i][j] += rect[i][j - 1];
                }
            }
            if (i > 0) {
                for (int j = 0; j < m; j++) {
                    rect[i][j] += rect[i - 1][j];
                }
            }
        }


        dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int z = 0; z < m; z++) {
                Arrays.fill(dp[i][z], -1);
            }
        }

        int ans = dp(0, 0, k);
        return ans;
    }
}
