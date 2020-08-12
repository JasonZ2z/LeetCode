package com.xinzhe.contest.weekly.season04.weekly163;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/6/16
 * Title : 1260. 二维网格迁移
 * Description : 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *              每次「迁移」操作将会引发下述活动：
 *              位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 *              位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 *              位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 *              请你返回 k 次迁移操作后最终得到的 二维网格。
 * link : https://leetcode-cn.com/problems/shift-2d-grid
 * Level : Easy
 * Comment 163周赛01
 */

public class Leetcode_weekly_16301 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}};
        System.out.println(shiftGrid(grid, 100));
    }
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                tmp.add(10001);
            }
            res.add(tmp);
        }
        System.out.println(res);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = i * n + j + k;
                int x = tmp / n;
                int y = tmp % n;
                while (x >= m) {
                    x = x - m;
                }
                res.get(x).set(y, grid[i][j]);
            }
        }
        return res;
    }
}
