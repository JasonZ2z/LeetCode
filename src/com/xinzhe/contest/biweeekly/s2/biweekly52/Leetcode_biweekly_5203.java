package com.xinzhe.contest.biweeekly.s2.biweekly52;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/06/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5203 {
    public static void main(String[] args) {
        Leetcode_biweekly_5203 lc = new Leetcode_biweekly_5203();
        int[][] grid= {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(lc.largestMagicSquare(grid));
    }
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 1 || n == 1) return 1;

        int[][] shu = new int[m+1][n+1];
        int[][] heng = new int[m+1][n+1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                heng[i+1][j+1] = heng[i+1][j] + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(heng));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                shu[i+1][j+1] = shu[i][j+1] + grid[i][j];
            }
        }
        int min = Math.min(m, n);
        for(int len = min; len >= 2; --len) {
            for (int i = 0; i + len <= m; ++i) {
                for (int j = 0; j + len <= n; ++j) {
                    int z =  heng[i + len][j+len] - heng[i+len][j];
                    if(shu[i + len][j+len] - shu[i][j+len] == z
                            && shu[i+len][j+1] - shu[i][j+1] == z
                            && heng[i+1][j+len] - heng[i+1][j] == z) {
                        int x = 0, y = 0;
                        for (int k = 0; k < len; ++k) {
                            x += grid[i + k][j + k];
                            y += grid[i+k][j+len-1 - k];
                        }
                        if(x == y && x == z) {
                            return len;
                        }
                    }
                }
            }
        }
        return 1;
    }
}