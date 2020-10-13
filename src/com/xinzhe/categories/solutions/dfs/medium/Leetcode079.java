package com.xinzhe.categories.solutions.dfs.medium;

/**
 * @author Xin
 * @date 2020/10/13
 * Title : 79. 单词搜索
 * Description : 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *              单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * link : https://leetcode-cn.com/problems/word-search
 * Level : Medium
 */

public class Leetcode079 {
    public static void main(String[] args) {
        char[][] arr = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        Leetcode079 lc = new Leetcode079();
        System.out.println(lc.exist(arr, "ABCESEEEFS"));
    }

    char[][] board;
    int m = 0, n = 0;
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.used = new boolean[m][n];
        char c = word.charAt(0);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == c) {
                    used[i][j] = true;
                    if(dfs(word, 1, i, j)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }
    int[][] paths = {{1, 0}, {0,1}, {-1, 0}, {0,-1}};
    private boolean dfs(String word, int index, int i, int j) {
        if(index == word.length()) return true;
        char c = word.charAt(index);
        for(int[] p : paths) {
            int x = i + p[0];
            int y = j + p[1];
            if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != c || used[x][y]) continue;
            used[x][y] = true;
            if(dfs(word, index + 1, x, y)) return true;
            used[x][y] = false;
        }
        return false;
    }
}
