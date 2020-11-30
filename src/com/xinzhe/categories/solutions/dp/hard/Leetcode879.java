package com.xinzhe.categories.solutions.dp.hard;

/**
 * @author Xin
 * @date 2020/11/27
 * Title : 879. 盈利计划
 * Description : 帮派里有 G 名成员，他们可能犯下各种各样的罪行。第i种犯罪会产生profit[i]的利润，它要求group[i]名成员共同参与。
 *              让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生P 的利润。有多少种方案可以选择？因为答案很大，所以返回它模10^9 + 7的值。
 * link : https://leetcode-cn.com/problems/profitable-schemes
 * Level : Hard
 */

//todo need to review
public class Leetcode879 {
    static final int MOD = (int)1e9 + 7;
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int n = group.length;
        long[][] dp = new long[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = P; j >= 0; --j) {
                for (int k = G - group[i]; k >= 0; --k) {
                    int x = Math.min(j + profit[i], P);
                    dp[k + group[i]][x] += dp[k][j];
                    dp[k + group[i]][x] %= MOD;
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= G; ++i) {
            res += dp[i][P];
            res %= MOD;
        }
        return (int) res;
    }

    public int profitableSchemes2(int G, int P, int[] group, int[] profit) {
        int n = group.length;
        int[][] dp = new int[G+1][P+1];
        for(int i=0; i<=G; i++) dp[i][0] = 1;
        int mod = (int)1e9 + 7;
        for(int i=0; i<n; i++) {
            int g = group[i], p = profit[i];
            for(int j = G; j >= g; j--) {
                for(int k = P; k >= 0; k--) {
                    if(k - p > 0) {
                        dp[j][k] += dp[j-g][k - p];
                    } else {
                        dp[j][k] += dp[j- g][0];
                    }
                    dp[j][k] %= mod;
                }
            }
        }
        return dp[G][P];
    }
}
