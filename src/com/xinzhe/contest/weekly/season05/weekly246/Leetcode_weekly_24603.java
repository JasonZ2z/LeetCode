package com.xinzhe.contest.weekly.season05.weekly246;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/06/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24603 {
    public static void main(String[] args) {
        Leetcode_weekly_24603 lc = new Leetcode_weekly_24603();
//        int[][] g1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
//        int[][] g2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        int[][] g1 ={{1,1,1,1,0,0},{1,1,0,1,0,0},{1,0,0,1,1,1},{1,1,1,0,0,1},{1,1,1,1,1,0},{1,0,1,0,1,0},{0,1,1,1,0,1},{1,0,0,0,1,1},{1,0,0,0,1,0},{1,1,1,1,1,0}};
        int[][] g2 ={{1,1,1,1,0,1},{0,0,1,0,1,0},{1,1,1,1,1,1},{0,1,1,1,1,1},{1,1,1,0,1,0},{0,1,1,1,1,1},{1,1,0,1,1,1},{1,0,0,1,0,1},{1,1,1,1,1,1},{1,0,0,1,0,0}};
        System.out.println(lc.countSubIslands(g1, g2));

    }
    int m, n;
    int[][] grid1, grid2;
    boolean[][] used1, used2;
    int[][] paths = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.m = grid1.length; this.n = grid1[0].length;
        this.grid1 = grid1; this.grid2 = grid2;
        this.used1 = new boolean[m][n]; this.used2 = new boolean[m][n];

        UF uf1 = extracted(grid1, used1);
        UF uf2 = extracted(grid2, used2);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid2[i][j] == 1) {
                    map.computeIfAbsent(uf2.find(i * 501 + j), a -> new ArrayList<>()).add(i * 501 + j);
                }
            }
        }
        int res = 0;
        for (List<Integer> values : map.values()) {
            Set<Integer> set = new HashSet<>();
            boolean flag = false;
            for (Integer value : values) {
                if(grid1[value/501][value%501] == 1) {
                    set.add(uf1.find(value));
                    if(set.size() > 1) {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            if(!flag && set.size() == 1) res++;
        }
        return res;
    }

    private UF extracted(int[][] grid, boolean[][] used) {
        UF uf = new UF(501 * 501);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !used[i][j]) {
                    dfs(grid, used, uf, i, j);
                }
            }
        }
        return uf;
    }

    private void dfs(int[][] grid, boolean[][] used, UF uf, int i, int j) {
        used[i][j] = true;
        for (int[] path : paths) {
            int x = i + path[0];
            int y = j + path[1];
            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || used[x][y]) continue;
            if(grid[x][y] == 1) {
               // System.out.println(i +  "            " + j + "/t" + x +  "            " + y);
                uf.union(i * 501 + j, x * 501 + y);
                dfs(grid, used, uf, x, y);
            }
        }
    }

    class UF {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private final int[] parent;
        // 记录树的“重量”
        private final int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public int count() {
            return count;
        }
    }

}


