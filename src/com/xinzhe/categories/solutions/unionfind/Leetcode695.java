package com.xinzhe.categories.solutions.unionfind;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/17
 * Title : 695. 岛屿的最大面积
 * Description : 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 *              找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * link : https://leetcode-cn.com/problems/max-area-of-island/
 * Level : Medium
 */

public class Leetcode695 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m*n;
        UF uf = new UF(len);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(grid[i][j] == 1){
                    if(i > 0 && grid[i-1][j] == 1) uf.union(i*n+j, (i-1)*n+j);
                    if(j > 0 && grid[i][j-1] == 1) uf.union(i*n+j, i*n+j-1);
//                    if(i+1 < m && grid[i+1][j] == 1) uf.union(i*n+j, (i+1)*n+j);
//                    if(j+1 < n && grid[i][j+1] == 1) uf.union(i*n+j, i*n+j+1);
                }
            }
        }
        int[] size = uf.size;
        int res = 0;
        for (int i = 0; i < len; ++i) {
            res = Math.max(res, size[i]);
        }
        return res;
    }

    static class UF{
        int[] parent;
        int[] size;

        public UF(int len){
            this.parent = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
            System.out.print(Arrays.toString(parent) + "           ");
            System.out.println(Arrays.toString(size));
            System.out.println();
        }

        public void union(int p, int q){
            int fp = find(p);
            int fq = find(q);
            if(fp == fq) return;
            if(size[fp] > size[fq]){
                parent[fq] = fp;
                size[fp] += size[fq];
            } else {
                parent[fp] = fq;
                size[fq] += size[fp];
            }
            System.out.print(Arrays.toString(parent) + "           ");
            System.out.println(Arrays.toString(size));
        }

        public int find(int p){
            while(parent[p] != p){
                p = parent[p];
            }
            return p;
        }
    }

}
