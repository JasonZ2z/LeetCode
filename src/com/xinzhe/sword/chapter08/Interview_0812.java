package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.12. 八皇后
 * Description : 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 * link : https://leetcode-cn.com/problems/eight-queens-lcci
 * Level : Hard
 */
public class Interview_0812 {
    public static void main(String[] args) {
        Interview_0812 lc = new Interview_0812();
    }
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = '.';
            }
        }
        dfs(grid, 0, n);
        return res;
    }

    private void dfs(char[][] grid, int i, int n) {
        if(i == n) {
            res.add(convert(grid));
            return;
        }
        for (int j = 0; j < n; j++) {
            if(helper(grid, i, j, n)) {
                grid[i][j] = 'Q';
                dfs(grid, i + 1, n);
                grid[i][j] = '.';
            }
        }
    }

    private List<String> convert(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (char[] rows : grid) {
            list.add(new String(rows));
        }
        return list;
    }

    private boolean helper(char[][] grid, int i, int j, int n) {
        for (int k = 0; k < i; ++k) {
            if(grid[k][j] == 'Q') return false;
        }
        for (int p = i-1, q = j-1; p >=0 && q >= 0; p--, q--) {
            if(grid[p][q] == 'Q') return false;
        }
        for (int p = i-1, q = j+1; p >= 0 && q < n; p--, q++) {
            if(grid[p][q] == 'Q') return false;
        }
        return true;
    }
}
