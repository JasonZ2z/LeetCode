package com.xinzhe.contest.biweeekly.s2.biweekly52;

/**
 * @author Xin
 * @date 2021/06/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5204 {
    public static void main(String[] args) {
        Leetcode_biweekly_5204 lc = new Leetcode_biweekly_5204();
    }
   public int test(){
       int[][] grid= {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
       int m = grid.length, n = grid[0].length;

       int[][] heng = new int[m][n];
       int[][] shu = new int[m][n];
       int min = Math.min(m, n);
       for(int len = min; len >= 2; --len) {
           for (int i = 0; i + len <= m; ++i) {
               for (int j = 0; j + len <= n; ++j) {
                   int z = heng[i + len -1][j+len-1] - heng[i+len-1][j];
                   if(shu[i + len-1][j+len-1] - shu[i][j+len-1] == z
                           && shu[i+len-1][j] - shu[i][j] == z
                           && heng[i][j+len-1] - heng[i][j] == z) {
                       int x = 0, y = 0;
                       for (int k = 0; k <= len; ++k) {
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