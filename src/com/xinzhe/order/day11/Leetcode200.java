package com.xinzhe.order.day11;

import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/4/17
 * Title : 200. 岛屿数量
 * Description : 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *              岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *              此外，你可以假设该网格的四条边均被水包围。
 * link : https://leetcode-cn.com/problems/number-of-islands
 * Level : Medium
 */

public class Leetcode200 {
    //dfs
    int[][] directions = {{1,0,-1,0},{0,1,0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == '1'){
                    dfs(grid, i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] != '1'){
            return;
        }
         grid[i][j] = '2';
        for (int k = 0; k < 4; ++k) {
            dfs(grid, i+directions[0][k], j+directions[1][k]);
        }
    }
    //bfs
    public int numIslands2(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.addLast(new int[]{i,j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int[] cur = queue.pollFirst();
                        for (int k = 0; k < 4; ++k) {
                            int x = cur[0] + directions[0][k];
                            int y = cur[1] + directions[1][k];
                            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1' || visited[x][y]){
                                continue;
                            }
                            queue.add(new int[]{x,y});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
    //并查集
    public int numIslands3(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        UF uf = new UF(grid);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    for (int k = 0; k < 4; ++k) {
                        int x = i+directions[0][k];
                        int y = j+directions[1][k];
                        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
                            continue;
                        }
                        uf.union(x*n+y, i*n+j);
                    }
                }
            }
        }
        return uf.count;
    }

    class UF{
        int count;
        int[] parent;
        int[] rank;

        public UF(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m*n];
            rank = new int[m*n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if(grid[i][j] == '1'){
                        parent[n*i+j] = i*n + j;
                        ++count;
                    }
                    rank[i*n+j] = 0;
                }
            }
        }

        public int find(int p){
            while (parent[p] != p){
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q){
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            if(rank[fp] > rank[fq]){
                parent[fq] = fp;
            } else  if(rank[fp] < rank[fq]){
                parent[fp] = fq;
            } else {
                parent[fp] = fq;
                rank[fq] += 1;
            }
            --count;
        }
    }
}
