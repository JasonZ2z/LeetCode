package com.xinzhe.contest.nowcoder.s1.s107;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0602 {

    public static void main(String[] args) {

        int[] f = {1};
        Point[] eg = new Point[0];
        System.out.println(solve(1, eg, f));
    }
    static HashSet[] map;
    static int res = 0;
    static int[] f;
    public static int solve (int n, Point[] edge, int[] fi) {
        // write code here
        map = new HashSet[n+1];
        f = fi;
        for (int i = 1; i <= n; ++i) {
            map[i] = new HashSet<>();
        }
        for (Point point : edge) {
            map[point.x].add(point.y);
            map[point.y].add(point.x);
        }
        dfs(1, -1, 0);
        return res;

    }

    private static void dfs(int i, int father, int steps) {
        HashSet<Integer> set = map[i];
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
