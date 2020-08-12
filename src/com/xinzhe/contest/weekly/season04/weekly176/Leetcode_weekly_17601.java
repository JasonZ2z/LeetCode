package com.xinzhe.contest.weekly.season04.weekly176;

/**
 * @author Xin
 * @date 2020/5/19
 * Title : 1351. 统计有序矩阵中的负数
 * Description : 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。请你统计并返回 grid 中 负数 的数目。
 * link : https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * Level : Easy
 * Comment 176周赛01
 */

public class Leetcode_weekly_17601 {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] >= 0) {
                    break;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
