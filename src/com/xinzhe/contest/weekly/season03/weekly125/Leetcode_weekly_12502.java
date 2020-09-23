package com.xinzhe.contest.weekly.season03.weekly125;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 999. 可以被一步捕获的棋子数
 * Description : 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。
 *              棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 * link : https://leetcode-cn.com/problems/available-captures-for-rook
 * Level : Easy
 */

public class Leetcode_weekly_12502 {
    public static void main(String[] args) {
        Leetcode_weekly_12502 lc = new Leetcode_weekly_12502();
    }
    public int numRookCaptures(char[][] board) {
        int[][] paths = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
        int ans = 0;
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if(board[i][j] == 'R') {
                    for(int[] p : paths) {
                        int x = i, y = j;
                        while(true) {
                            x += p[0];
                            y += p[1];
                            if(x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') break;
                            if(board[x][y] == 'p') {
                                ans++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
