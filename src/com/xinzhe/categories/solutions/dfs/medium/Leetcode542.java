package com.xinzhe.categories.solutions.dfs.medium;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/4/15 14:56
 * Title : 542. 01 矩阵
 * Description : 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。两个相邻元素间的距离为 1 。
 * link : https://leetcode-cn.com/problems/01-matrix/
 * Level : Medium
 */

public class Leetcode542 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = updateMatrix(arr);
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; ++j) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] directions = {{1,0,-1,0},{0,1,0,-1}};
    private static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0][];
        int n = matrix[0].length;

        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; ++i) {
                int newX = x + directions[0][i];
                int newY = y + directions[1][i];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]){
                    continue;
                }
                res[newX][newY] = res[x][y] + 1;
                visited[newX][newY] = true;
                queue.addLast(new int[]{newX, newY});
            }
        }
        return res;
    }
}
