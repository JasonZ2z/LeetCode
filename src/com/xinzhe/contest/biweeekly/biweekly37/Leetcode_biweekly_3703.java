package com.xinzhe.contest.biweeekly.biweekly37;

/**
 * @author Xin
 * @date 2020/10/17
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3703 {
    public static void main(String[] args) {
        Leetcode_biweekly_3703 lc = new Leetcode_biweekly_3703();
        System.out.println(lc.numberOfSets(4, 2));
    }
    static final int MOD = (int)1e9 + 7;
    long[][][] dp;
    public int numberOfSets(int n, int k) {
        this.dp = new long[n][n][k+1];
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                for (int l = 0; l < k; ++l) {
                    dp[i][j][k] = -1;
                }
            }
        }
        solve(0,n-1,k);
        return Math.toIntExact(dp[0][n-1][k] % MOD);
    }

    private long solve(int x, int y, int k) {
        if(k == 0) return 0;
        if(x == y) return 0;
        if(k == 1) return 1;
        if(y - x == 1) return 0;

        if(dp[x][y][k] != -1) return dp[x][y][k];
        long ans = 0;
        for (int i = x; i < y; ++i) {
            for (int j = y; j - i > 1 ; y--) {
                if(i == x && j == y) continue;

                ans +=0;
            }
        }
        dp[x][y][k] = ans;
        return ans;
    }

}
