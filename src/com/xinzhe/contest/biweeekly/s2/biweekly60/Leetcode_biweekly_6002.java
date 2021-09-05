package com.xinzhe.contest.biweeekly.s2.biweekly60;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2021/09/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6002 {
    public static void main(String[] args) {
        Leetcode_biweekly_6002 lc = new Leetcode_biweekly_6002();
        
    }
    int m,n;
    int[][] land;
    boolean[][] used;
    int[][] paths = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int[][] findFarmland(int[][] land) {
        this.m = land.length;
        this.n = land[0].length;
        this.land = land;
        this.used = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(land[i][j] == 1 && !used[i][j]) {
                    TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                    bfs(i,j, set);
                    res.add(new int[]{i, j, set.last()[0], set.last()[1]});
                }
            }
        }
        int[][] result = new int[res.size()][4];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void bfs(int i, int j, TreeSet<int[]> set) {
        used[i][j] = true;
        set.add(new int[]{i, j});
        for(int k=0; k<4; k++) {
            int x = i + paths[k][0];
            int y = j + paths[k][1];
            if(x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 1 || used[x][y]) continue;
            bfs(x, y, set);
        }
    }

}