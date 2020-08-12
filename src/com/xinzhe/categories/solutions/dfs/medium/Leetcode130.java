package com.xinzhe.categories.solutions.dfs.medium;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/4/3 13:53
 * Title : 130. 被围绕的区域
 * Description : 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * link : https://leetcode-cn.com/problems/surrounded-regions/
 * Level : medium
 */

public class Leetcode130 {
    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'},
                      {'O','X','O','X','O','X'},
                      {'X','O','X','O','X','O'},
                      {'O','X','O','X','O','X'}};



        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        solve(board);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        int[][] directions = {{1,0,-1,0},
                              {0,1,0,-1}};
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m-1||j == 0||j == n-1) {
                    if (board[i][j] == 'O') {
                       stack.add(new int[]{i,j});
                    }
                }
            }
        }
        boolean[][] used = new boolean[m][n];

        while (!stack.isEmpty()){
            int[] cur = stack.pop();
            int x = cur[0];
            int y = cur[1];
            if(used[x][y]){
                continue;
            } else {
                used[x][y] = true;
            }
            for (int k = 0; k < 4; ++k) {
                int newX = x + directions[0][k];
                int newY = y + directions[1][k];
                if (newX >= m-1  || newX < 1 || newY >= n-1  || newY < 1 || board[newX][newY] != 'O') {
                    continue;
                }
                stack.add(new int[]{newX, newY});
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = used[i][j] ? 'O' : 'X';
            }
        }
    }
}
