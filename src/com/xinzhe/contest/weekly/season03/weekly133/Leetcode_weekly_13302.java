package com.xinzhe.contest.weekly.season03.weekly133;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/9/10
 * Title : 1030. 距离顺序排列矩阵单元格
 * Description : 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *              返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * link : https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 * Level : Easy
 */

public class Leetcode_weekly_13302 {
    public static void main(String[] args) {
        Leetcode_weekly_13302 lc = new Leetcode_weekly_13302();
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<List<int[]>> res = new ArrayList<>(R+C);
        for (int i = 0; i < R+C-1; ++i) {
            res.add(new ArrayList<>());
        }
        int[][] paths = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0,c0});
        boolean[][] used = new boolean[R][C];
        used[r0][c0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int index = Math.abs(cur[0] - r0) + Math.abs(cur[1] - c0);
            res.get(index).add(cur);
            count++;
            for(int[] path : paths) {
                int x = cur[0] + path[0];
                int y = cur[1] + path[1];
                if(x < 0 || x >= R || y < 0 || y >= C || used[x][y]) continue;
                queue.offer(new int[]{x, y});
                used[x][y] = true;
            }
        }
        int[][] ans = new int[count][2];
        int i = 0;
        for (List<int[]> list : res) {
            for (int[] ints : list) {
                ans[i++] = ints;
            }
        }
        return ans;
    }
}
