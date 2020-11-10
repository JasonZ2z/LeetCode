package com.xinzhe.categories.solutions.backtrack.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/9/3
 * Title : 51. N 皇后
 * Description : n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * link : https://leetcode-cn.com/problems/n-queens/
 * Level : Hard
 */
//todo need to review
public class Leetcode051 {
    public static void main(String[] args) {
    }
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = '.';
            }
        }
        dfs(grid, n, 0);
        return res;
    }

    private boolean dfs(char[][] grid, int n, int i) {
        if(i == n) {
            res.add(convert(grid));
            return true;
        }
        for (int j = 0; j < n; ++j) {
            if(judge(grid, n, i,j)) {
                grid[i][j] = 'Q';
                if(dfs(grid, n, i+1)) return true;
                grid[i][j] = '.';
            }
        }
        return false;
    }

    private boolean judge(char[][] grid, int n, int i, int j) {
        for (int k = 0; k < i; ++k) if(grid[k][j] == 'Q') return false;
        for (int p = i-1,q = j+1; p >= 0 && q < n; p--, q++) if(grid[p][q] == 'Q') return false;
        for (int p = i-1,q = j-1; p >= 0 && q >=0; p--, q--) if(grid[p][q] == 'Q') return false;
        return true;
    }

    private List<String> convert(char[][] grid) {
        List<String> list = new ArrayList<>();
        for (char[] chars : grid) {
            list.add(new String(chars));
        }
        return list;
    }
}
