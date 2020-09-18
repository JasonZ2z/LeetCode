package com.xinzhe.contest.weekly.season03.weekly130;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1020. 飞地的数量
 * Description : 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界. 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * link : https://leetcode-cn.com/problems/number-of-enclaves
 * Level : Medium
 */

public class Leetcode_weekly_13004 {
    public static void main(String[] args) {
        Leetcode_weekly_13004 lc = new Leetcode_weekly_13004();
    }
    public int numEnclaves(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean[][] used = new boolean[m][n];
        int c = 0;
        for (int i = 0; i < n; ++i) {
            if(arr[0][i] == 1) {
                c += count(arr, used, 0, i);
            }
            if(arr[m-1][i] == 1) {
                c += count(arr, used, m-1, i);
            }
        }

        for (int i = 1; i < m - 1; ++i) {
            if(arr[i][0] == 1) {
                c += count(arr, used, i, 0);
            }
            if(arr[i][n-1] == 1) {
                c += count(arr, used, i, n-1);
            }
        }
        int t = 0;
        for (int[] a : arr) {
            for (int j = 0; j < n; ++j) {
                if (a[j] == 1) t++;
            }
        }
        return t - c;
    }
    int[][] paths = {{1,0},{0,1}, {-1, 0}, {0,-1}};
    private int count(int[][] arr, boolean[][] used, int i, int j) {
        if(used[i][j]) return 0;
        int res = 1;
        used[i][j] = true;
        for (int[] path : paths) {
            int x = i + path[0];
            int y = j + path[1];
            if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == 0 || used[x][y]) continue;
            res += count(arr, used, x, y);
        }
        return res;
    }
}
