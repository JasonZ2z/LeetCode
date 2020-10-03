package com.xinzhe.contest.weekly.season03.weekly125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/9/23
 * Title : 1001. 网格照明
 * Description : 在 N x N 的网格上，每个单元格 (x, y) 上都有一盏灯，其中 0 <= x < N 且 0 <= y < N 。
 *              最初，一定数量的灯是亮着的。lamps[i] 告诉我们亮着的第 i 盏灯的位置。每盏灯都照亮其所在 x 轴、y 轴和两条对角线上的每个正方形（类似于国际象棋中的皇后）。
 *              对于第 i 次查询 queries[i] = (x, y)，如果单元格 (x, y) 是被照亮的，则查询结果为 1，否则为 0 。
 *              在每个查询 (x, y) 之后 [按照查询的顺序]，我们关闭位于单元格 (x, y) 上或其相邻 8 个方向上（与单元格 (x, y) 共享一个角或边）的任何灯。
 *              返回答案数组 answer。每个值 answer[i] 应等于第 i 次查询 queries[i] 的结果。
 * link : https://leetcode-cn.com/problems/grid-illumination
 * Level : Hard
 */

//todo need to review
    // 关于对角线的表示
    // 正对角线 r - c 都相等
    // 反对角线 r + c 都相等
public class Leetcode_weekly_12504 {
    public static void main(String[] args) {
        Leetcode_weekly_12504 lc = new Leetcode_weekly_12504();
        int[][] arr = {{0,0},{0,1},{0,4}};
        int[][] x = {{0,0},{0,1},{0,2}};
        System.out.println(Arrays.toString(lc.gridIllumination(5, arr, x)));
    }
    Map<Integer, Integer> lampsR, lampsC, lampsX, lampsY = new HashMap<>();
    int[][] paths = {{0,0}, {1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        long inf = (long)1e9 + 7;
        Set<Long> lampList =  new HashSet<>();
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            lampsR.put(r, lampsR.getOrDefault(r, 0) + 1);
            lampsC.put(c, lampsC.getOrDefault(c, 0) + 1);
            lampsX.put(c - r, lampsX.getOrDefault(c - r, 0) + 1);
            lampsY.put(c + r, lampsY.getOrDefault(c + r, 0) + 1);
            lampList.add(r * inf + c);
        }
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int r = query[0], c = query[1];
            if (lampsR.containsKey(r) || lampsC.containsKey(c) || lampsX.containsKey(c - r) || lampsY.containsKey(c + r))
                res[i] = 1;
            for (int[] path : paths) {
                int x = r + path[0];
                int y = c + path[1];
                if(lampList.contains(x * inf + y))  {
                    close(x, y);
                    lampList.remove(x * inf + y);
                }
            }
        }
        return res;
    }

    private void close(int r, int c) {
        if(lampsR.containsKey(r)) {
            lampsR.put(r, lampsR.get(r) - 1);
            if(lampsR.get(r) == 0) lampsR.remove(r);
        }
        if(lampsC.containsKey(c)) {
            lampsC.put(c, lampsC.get(c) - 1);
            if(lampsC.get(c) == 0) lampsC.remove(c);
        }
        if(lampsX.containsKey(c - r)) {
            lampsX.put(c - r, lampsX.get(c - r) - 1);
            if(lampsX.get(c - r) == 0) lampsX.remove(c - r);
        }
        if(lampsY.containsKey(c + r)) {
            lampsY.put(c + r, lampsY.get(c + r) - 1);
            if(lampsY.get(c + r) == 0) lampsY.remove(c + r);
        }
    }
}
