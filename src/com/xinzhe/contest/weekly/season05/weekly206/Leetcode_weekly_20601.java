package com.xinzhe.contest.weekly.season05.weekly206;

/**
 * @author Xin
 * @date 2020/9/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20601 {
    public static void main(String[] args) {
        Leetcode_weekly_20601 lc = new Leetcode_weekly_20601();
        //int[][] arr = {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int[][] arr = {{0,0},{0,0},{1,0}};
        System.out.println(lc.numSpecial(arr));

    }

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int c = 0;
        for (int[] ints : mat) {
            int sum = 0, index = 0;
            boolean flag = true;
            for (int k = 0; k < n; ++k) {
                if (ints[k] == 1) {
                    sum++;
                    index = k;
                    if (sum > 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag || sum == 0) continue;
            int s = 0;
            for (int j = 0; j < m; ++j) {
                if (mat[j][index] == 1) {
                    s++;
                    if (s > 1) break;
                }
            }
            if (s == 1) c++;
        }
        return c;
    }

}
