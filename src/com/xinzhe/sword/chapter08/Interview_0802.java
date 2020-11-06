package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.02. 迷路的机器人
 * Description : 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *              网格中的障碍物和空位置分别用 1 和 0 来表示。返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组.
 * link : https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * Level : Medium
 */
//todo need to review
public class Interview_0802 {
    List<List<Integer>> res = new ArrayList<>();
    int[][] obstacleGrid;
    boolean[][] used;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        this.used = new boolean[m][n];
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return res;
        if(dfs(0,0, m-1, n-1, new ArrayList<>())) {
            return res;
        }
        return new ArrayList<>();
    }

    //但其实这个题目仍然需要 visited 标识，因为我们可以通过不同的路径到达同一个位置：比如身处位置 (0,0) 时，可以通过"先右再下"和“先下再右”两种方式到达 (1,1)。
    //注意回溯撤销选择时只是将obstacleGrid[x][y]移出，used[x][y]不需要改回false，因为我们已经确定经过obstacleGrid[x][y]无法到达右下角了。
    private boolean dfs(int i, int j, int m, int n, List<List<Integer>> track) {
        if(i == m + 1 || j == n +1 || used[i][j] ||obstacleGrid[i][j] == 1)  return false;
        track.add(Arrays.asList(i, j));
        used[i][j] = true;
        if(i == m && j == n) {
            res = new ArrayList<>(track);
            return true;
        }
        if(dfs(i + 1, j, m, n, track)) return true;
        if(dfs(i, j + 1, m, n, track)) return true;
        track.remove(track.size() - 1);
        return false;
    }
}
