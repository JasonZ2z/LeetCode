package com.xinzhe.categories.structure.arrays;

/**
 * @author Xin
 * @date 2020/4/2 18:37
 * Title : 289. 生命游戏
 * Description : 根给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 *              每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *          如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *          如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *          如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *          如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *          根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * link : https://leetcode-cn.com/problems/game-of-life
 * Level : Medium
 */

//原地算法
public class Leetcode289 {

    //01 | count(1) < 2 | count(1) > 3
    //11 | count(1) == 2|3
    //10 | count(1) == 3
    private int[][] directions = {{1,1,0,-1,-1,-1, 0, 1},
                                {0,1,1, 1, 0,-1,-1,-1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int c = count(board, i,j);
                if(board[i][j] == 0) {
                    if (c == 3) {
                        board[i][j] = 2;
                    }
                }
                if(board[i][j] == 1){
                    if(c == 2 || c == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] >>=1;
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        int c = 0;
        for (int k = 0; k < 8; ++k) {
            int x = i + directions[0][k];
            int y = j + directions[1][k];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            c += (board[x][y] & 1);
        }
        return c;
    }
}
