package com.xinzhe.categories.solutions.backtrack.hard;

/**
 * @author Xin
 * @date 2020/9/15
 * Title : 37. 解数独
 * Description : 编写一个程序，通过已填充的空格来解决数独问题。一个数独的解法需遵循如下规则：
 *              数字 1-9 在每一行只能出现一次。
 *              数字 1-9 在每一列只能出现一次。
 *              数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *              空白格用 '.' 表示。
 * link : https://leetcode-cn.com/problems/sudoku-solver
 * Level : Hard
 */

public class Leetcode037 {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int n) {
        if(n == 81) return true;
        int r = n / 9, c = n % 9;
        if(board[r][c] != '.') return backtrack(board, n+1);
        for (char ch = '1'; ch <= '9'; ++ch) {
            if(!isValid(board, r, c, ch)) continue;
            board[r][c] = ch;
            if(backtrack(board, n+1)) return true;
            board[r][c] = '.';
        }
        return false;
    }
    //todo need to review
    private boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; ++k) {
            if(board[i][k] == ch) return false;
            if(board[k][j] == ch) return false;
            if(board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == ch) return false;
        }
        return true;
    }

    public void solveSudoku2(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') return solveSudokuHelper(board, n + 1, row, col, box);

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) continue;
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) return true;
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }
}
