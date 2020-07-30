package com.xinzhe.contest.nowcoder.s107;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0602 {

    public static void main(String[] args) {
        nowcoder_0602 nc = new nowcoder_0602();
        int[] f = {1};
        Point[] eg = new Point[0];
        System.out.println(nc.solve(1, eg, f));
    }
    Set<Integer>[] map;
    int res = 0;
    int[] f;
    public int solve (int n, Point[] Edge, int[] f) {
        // write code here
        this.map = new HashSet[n+1];
        this.f = f;
        for (int i = 1; i <= n; ++i) {
            map[i] = new HashSet<>();
        }
        for (Point point : Edge) {
            map[point.x].add(point.y);
            map[point.y].add(point.x);
        }
        dfs(1, -1, 0);
        return res;

    }

    private void dfs(int i, int father, int steps) {
        Set<Integer> set = map[i];
        if(set.size() == 1 && set.contains(father) && steps <= 2){
            res++;
            return;
        }
        if(steps > 2) return;
        for (Integer j : set) {
            if(j != father) {
                dfs(j, i, steps + f[j-1]);
            }
        }
    }


    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
