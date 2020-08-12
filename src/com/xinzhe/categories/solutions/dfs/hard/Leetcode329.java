package com.xinzhe.categories.solutions.dfs.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/7/26
 * Title : 329. 矩阵中的最长递增路径
 * Description : 给定一个整数矩阵，找出最长递增路径的长度。对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * link : https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
 * Level : Hard
 */
public class Leetcode329 {
    int[][] path = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    int longest = 1;
    int[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(matrix, i, j);
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if(visited[i][j] != 0) return visited[i][j];
        visited[i][j] = 1;
        for (int k = 0; k < 4; ++k) {
            int x = i + path[k][0];
            int y = j + path[k][1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            visited[i][j] = Math.max(visited[i][j], dfs(matrix, x,y) + 1);
        }
        longest = Math.max(longest, visited[i][j]);
        return visited[i][j];
    }


    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix==null||matrix.length==0){
            return 0;
        }
        int[][] count = new int[matrix.length][matrix[0].length];
        int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //统计每个点的入度用count数组保存，因为是递增，所以如果在上下左右，每发现一个比当前点小的数，当前点入度+1
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int[] d : direction) {
                    if (longestIncreasingPathVerify(matrix, i, j, d[0], d[1])) {
                        count[i][j]++;
                    }
                }
            }
        }
        Deque<int[]> deque = new LinkedList<>();
        //count数组中所有入度为0的点加入队列
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i].length; j++) {
                if (count[i][j] == 0) {
                    deque.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!deque.isEmpty()) {
            ans++;
            //这个跟课程表I那个题不一样，需要一层一层的出列，而不是一个一个的出，因为课程表那个不关心队列长度
            for (int size = deque.size(); size > 0; size--) {
                int[] poll = deque.poll();
                for (int[] d : direction) {
                    if (longestIncreasingPathVerify(matrix, poll[0], poll[1], d[0], d[1])) {
                        if (--count[poll[0] + d[0]][poll[1] + d[1]] == 0) {
                            deque.add(new int[]{poll[0] + d[0], poll[1] + d[1]});
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean longestIncreasingPathVerify(int[][] matrix, int i, int j, int x, int y) {
        int newX = i + x;
        int newY = j + y;
        return newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[i].length && matrix[newX][newY] > matrix[i][j];
    }
}
