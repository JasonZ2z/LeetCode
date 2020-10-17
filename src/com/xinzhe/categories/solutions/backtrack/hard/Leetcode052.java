package com.xinzhe.categories.solutions.backtrack.hard;

/**
 * @author Xin
 * @date 2020/10/17
 * Title : 52. N皇后 II
 * Description : n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * link : https://leetcode-cn.com/problems/n-queens-ii/
 * Level : Hard
 */

public class Leetcode052 {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n < 1) return 0;
        dfs(0,0,0,0,n);
        return count;
    }

    private void dfs(int row, int col, int pie, int na,int n) {
        if (row >= n) {
            count++;
            return;
        }
        int bit = (~(col | pie | na)) // 获取当前空位 标识为1
                & ((1<<n) - 1);  // 去掉所有高位
        while (bit > 0){//遍历所有空位
            int p = bit & -bit; //获取最后的空位 1
            /*
             col | p 表示 p 位被占用
             (pie | p ) << 1 ,表示pie往斜左方移一位 被占用
             (na | p) >> 1,表示na往斜右方移一位 被占用
             */
            dfs(row + 1,col | p,(pie | p ) << 1,(na | p) >> 1,n);
            bit &= (bit - 1); // 打掉最后的1
        }
    }
}
