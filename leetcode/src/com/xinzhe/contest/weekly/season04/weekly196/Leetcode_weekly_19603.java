package com.xinzhe.contest.weekly.season04.weekly196;

/**
 * @Author Xin
 * @create 2020/7/5
 * Title : 1504. 统计全 1 子矩形
 * Description : 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 * link : https://leetcode-cn.com/problems/count-submatrices-with-all-ones/
 * Level : Medium
 * Comment 196周赛03
 */
public class Leetcode_weekly_19603 {
    public static void main(String[] args) {
        Leetcode_weekly_19603 lc = new Leetcode_weekly_19603();
        int[][] mat = {{1,1,1,1,0,1,0},{1,1,1,0,0,0,1},{0,1,1,1,1,0,0},{1,1,0,1,1,0,1},{1,0,0,0,0,0,1},{1,1,0,1,1,1,1},{1,1,0,0,1,1,1}};
        System.out.println(lc.numSubmat(mat));
    }
    //todo need to review
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m+1][n];
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(mat[i][j] == 1) {
                    dp[i+1][j] = dp[i][j] + 1;
                    int cur = dp[i+1][j];
                    for(int k = j; k >= 0 && cur > 0; --k) {
                        cur = Math.min(cur, dp[i+1][k]);
                        count += cur;
                    }
                }
            }
        }
        return count;
    }
}
