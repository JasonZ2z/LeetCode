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
public class Leetcode_weekly_18804 {
    public int ways(String[] pizza, int k) {
        Integer[][][] dp = new Integer[pizza.length][pizza[0].length()][k];
        return ways(pizza, 0, 0, k - 1, dp);
    }

    private int ways(String[] pizza, int n, int m, int k, Integer[][][] dp) {
        if (dp[n][m][k] != null) {
            return dp[n][m][k];
        } else if (!ways(pizza, n, pizza.length, m, pizza[0].length())) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else {
            int count = 0;
            for (int i = n + 1; i < pizza.length; i++) {
                if (ways(pizza, n, i, m, pizza[0].length())) {
                    count = (count + ways(pizza, i, m, k - 1, dp)) % 1000000007;
                }
            }
            for (int i = m + 1; i < pizza[0].length(); i++) {
                if (ways(pizza, n, pizza.length, m, i)) {
                    count = (count + ways(pizza, n, i, k - 1, dp)) % 1000000007;
                }
            }
            return dp[n][m][k] = count;
        }
    }

    private boolean ways(String[] pizza, int a, int b, int c, int d) {
        for (int i = a; i < b; i++) {
            for (int j = c; j < d; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }


    public int ways2(String[] pizza, int k) {
        int mod = 1000000007;
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] p = new int[m][n];
        for(int i = 0; i < m; i++) {
            String cur = pizza[i];
            for(int j = 0; j < n; j++) if(cur.charAt(j) == 'A') p[i][j] = 1;
        }
        for(int j = 0; j < m; j++) {
            System.out.println(Arrays.toString(p[j]));
        }
        System.out.println("-----------------------------");
        for(int i = m - 2; i >= 0; i--) {
            p[i][n - 1] += p[i + 1][n - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            p[m - 1][i] += p[m - 1][i + 1];
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                p[i][j] += p[i + 1][j] + p[i][j + 1] - p[i + 1][j + 1];
            }
        }
        int[][][] dp = new int[k + 1][m][n]; //dp[i][j][k] : 左上角为（i，j）的pizza切k块，每块都有pizza的方案数
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) if(p[i][j] != 0){
                dp[1][i][j] = 1;
            }
        }
        for(int t = 2; t <= k; t++) {
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    //update dp[i][j][t]
                    for(int a = i + 1; a < m; a++) {
                        if(p[i][j] - p[a][j] != 0) {
                            dp[t][i][j] += dp[t - 1][a][j];
                            dp[t][i][j] %= mod;
                        }
                    }
                    for(int a = j + 1; a < n; a++) {
                        if(p[i][j] - p[i][a] != 0) {
                            dp[t][i][j] += dp[t - 1][i][a];
                            dp[t][i][j] %= mod;
                        }
                    }
                }
            }
        }
        for(int i = 1; i < k; i++) {
            for(int j = 0; j < m; j++) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
            System.out.println("-----------------------------");
        }
        return dp[k][0][0];
    }
}
