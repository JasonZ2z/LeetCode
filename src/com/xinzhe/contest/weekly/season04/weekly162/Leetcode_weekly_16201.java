package com.xinzhe.contest.weekly.season04.weekly162;

/**
 * @Author Xin
 * @create 2020/6/17
 * Title : 1252. 奇数值单元格的数目
 * Description : 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *              另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *              你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *              请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 * link : https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * Level : Easy
 * Comment 162周赛01
 */

public class Leetcode_weekly_16201 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}};
    }
    public int oddCells(int n, int m, int[][] indices) {
        int[][] dp = new int[n][m];
        for (int[] a : indices) {
            for (int i = 0; i < m; ++i) {
                dp[a[0]][i]++;
            }
            for (int i = 0; i < n; ++i) {
                dp[i][a[1]]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if((dp[i][j] & 1) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
