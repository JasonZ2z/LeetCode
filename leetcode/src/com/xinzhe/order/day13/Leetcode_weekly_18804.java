package com.xinzhe.order.day13;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title : 1444. 切披萨的方案数
 * Description : 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。
 *              你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 *              切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。
 *              如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
 *              请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
 * link : https://leetcode-cn.com/problems/number-of-ways-of-cutting-a-pizza
 * Level : Hard
 */
//todo need to review
public class Leetcode_weekly_18804 {
    public static void main(String[] args) {
        String[] t = {".A..A","A.A..","A.AA.","AAAA.","A.AA."};
        System.out.println(ways(t, 5));
    }
    public static int ways(String[] pizza, int k) {
        int mod = (int) (1e9 + 7);
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] p = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int up = i > 0 ? p[i-1][j] : 0;
                int left = j > 0 ? p[i][j-1] : 0;
                int upleft = i>0&&j>0 ? p[i-1][j-1] : 0;
                if(pizza[i].charAt(j) == 'A') {
                    p[i][j] = up + left - upleft + 1;
                } else {
                    p[i][j] = up + left - upleft;
                }
            }
        }
        int[][][] dp = new int[m][n][k+1];
        dp[0][0][1] = 1;
        for (int a = 2; a <= k; ++a) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if(dp[i][j][a-1] == 0) continue;
                    for (int l = i+1; l < m; ++l) {
                        if(hasA(p,i,j, l,n) && hasA(p, l,j,m,n)) {
                            dp[l][j][a] += dp[i][j][a-1];
                            dp[l][j][a] %= mod;
                        }
                    }
                    for (int l = j+1; l < n; ++l) {
                        if(hasA(p,i,j, m,l) && hasA(p, i,l,m,n)) {
                            dp[i][l][a] += dp[i][j][a-1];
                            dp[i][l][a] %= mod;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println(dp[i][j][k]);
                ans+=dp[i][j][k];
            }
            ans%=mod;
        }
        return (int) ans;
    }

    private static boolean hasA(int[][] p, int i, int j, int m, int n) {
        int num1 = i > 0 && j > 0 ? p[i-1][j-1] : 0;
        int num2 = i > 0 ? p[i-1][n-1] : 0;
        int num3 = j > 0 ? p[m-1][j-1] : 0;
        return (p[m-1][n-1] - num2 -num3 + num1) > 0;
    }


    //逆序方式
    public static int ways2(String[] pizza, int k) {
        int mod = 1000000007;
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] p = new int[m][n];
        for(int i = 0; i < m; i++) {
            String cur = pizza[i];
            for(int j = 0; j < n; j++) if(cur.charAt(j) == 'A') p[i][j] = 1;
        }
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
        return dp[k][0][0];
    }
}
