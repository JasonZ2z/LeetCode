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
public class Leetcode_weekly_18804_2 {
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        int[][] rowSum = new int[n][m];  // rowSum[i][j] 表示 (i, j) 位置之后的行内的苹果数
        int[][] colSum = new int[n][m];  // colSum[i][j] 表示 (i, j) 位置之下的列内的苹果数
        for (int i = 0; i < n; i++) {
            rowSum[i][m - 1] = pizza[i].charAt(m - 1) == 'A' ? 1 : 0;
            for (int j = m - 2; j >= 0; j--) {
                rowSum[i][j] = rowSum[i][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }
        for (int i = 0; i < m; i++) {
            colSum[n - 1][i] = pizza[n - 1].charAt(i) == 'A' ? 1 : 0;
            for (int j = n - 2; j >= 0; j--) {
                colSum[j][i] = colSum[j + 1][i] + (pizza[j].charAt(i) == 'A' ? 1 : 0);
            }
        }
        int[][][] f = new int[n][m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(f[i][j], -1);
            }
        }
        return dp(0, 0, k - 1, f, rowSum, colSum, pizza);
    }

    private int dp(int x, int y, int k, int[][][] f, int[][] rowSum, int[][] colSum, String[] pizza) {
        if (f[x][y][k] >= 0) {
            return f[x][y][k];
        }
        if (k == 0) {
            for (int i = x; i < pizza.length; i++) {
                for (int j = y; j < pizza[0].length(); j++) {
                    if (pizza[i].charAt(j) == 'A') {
                        return f[x][y][k] = 1;
                    }
                }
            }
            return f[x][y][k] = 0;
        }
        long res = 0;
        for (int nx = x + 1, apples = 0; nx < pizza.length; nx++) {
            apples += rowSum[nx - 1][y];
            if (apples > 0) {
                res += dp(nx, y, k - 1, f, rowSum, colSum, pizza);
                res %= 1000000007;
            }
        }
        for (int ny = y + 1, apples = 0; ny < pizza[0].length(); ny++) {
            apples += colSum[x][ny - 1];
            if (apples > 0) {
                res += dp(x, ny, k - 1, f, rowSum, colSum, pizza);
                res %= 1000000007;
            }
        }
        f[x][y][k] = (int) res;
        return (int) res;
    }
}
