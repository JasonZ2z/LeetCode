package com.xinzhe.categories.solutions.dp.hard;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/27
 * Title : 741. 摘樱桃
 * Description : 一个N x N的网格(grid)代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 *              0 表示这个格子是空的，所以你可以穿过它。
 *              1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 *              -1 表示这个格子里有荆棘，挡着你的路。
 *          你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 *              从位置(0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 *              当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 *              当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 *              如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 * link : https://leetcode-cn.com/problems/cherry-pickup
 * Level : Hard
 */

//todo need to review
public class Leetcode741 {
    public static void main(String[] args) {
        Leetcode741 lc = new Leetcode741();
        int[][] arr = {{0,1,-1}, {1,0,-1}, {1,1,1}};
        System.out.println(lc.cherryPickup(arr));
    }
    int n;
    int[][][] dp;
    int[][] grid;
    int inf = -(int)1e9;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.dp = new int[n][n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], inf);
            }
        }
        return Math.max(0, dfs(0,0,0));
    }

    private int dfs(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if(r1 == n || c1 == n || r2 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return inf;
        if(r1 == n - 1 && c1 == n-1) return grid[r1][c1];
        if(dp[r1][c1][r2] != inf) return dp[r1][c1][r2];
        int ans = grid[r1][c1];
        if(r1 != r2) ans += grid[r2][c2];
        ans += Math.max(Math.max(dfs(r1 + 1, c1, r2 + 1), dfs(r1, c1 + 1, r2)),
                        Math.max(dfs(r1 + 1, c1, r2), dfs(r1, c1 + 1, r2 + 1)));
        dp[r1][c1][r2] = ans;
        return ans;
    }
}
