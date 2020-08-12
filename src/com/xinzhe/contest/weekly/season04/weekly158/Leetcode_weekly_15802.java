package com.xinzhe.contest.weekly.season04.weekly158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Xin
 * @date 2020/7/15
 * Title : 1222. 可以攻击国王的皇后
 * Description : 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。「黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
 *              「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
 * link : https://leetcode-cn.com/problems/queens-that-can-attack-the-king
 * Level : Medium
 */

public class Leetcode_weekly_15802 {

    public static void main(String[] args) {
        Leetcode_weekly_15802 lc = new Leetcode_weekly_15802();
        int[][] arr = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0,0};
        System.out.println(lc.queensAttacktheKing(arr,king));
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int x = king[0], y = king[1];
        int[][] path = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1}, {1,-1}};
        List<Pair> list = new ArrayList<>();
        for (int[] queen : queens) {
            list.add(new Pair(queen[0], queen[1]));
        }
        boolean[] visited = new boolean[8];
        for (int i = 1; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if(!visited[j]) {
                    int newX = x + path[j][0] * i;
                    int newY = y + path[j][1] * i;
                    if(newX < 0 || newX >= 8 || newY < 0 || newY >= 8) continue;
                    if(list.contains(new Pair(newX, newY))){
                        res.add(Arrays.asList(newX, newY));
                        visited[j] = true;
                    }
                }
            }
        }
        return res;
    }
    class Pair{
        int x; int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
