package com.xinzhe.order.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18803_3 {
    private boolean[] subTreeHasApple;
    private List<List<Integer>> neighbors;
    private List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        subTreeHasApple = new boolean[n];
        this.hasApple = hasApple;
        neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (var edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        getSubTreeHasApple(-1, 0);
        return getAnswer(-1, 0);
    }

    private int getAnswer(int father, int current) {
        int res = 0;
        for (int next : neighbors.get(current)) {
            if (next != father && subTreeHasApple[next]) {
                res += getAnswer(current, next) + 2;
            }
        }
        return res;
    }

    private void getSubTreeHasApple(int father, int current) {
        if (hasApple.get(current)) {
            subTreeHasApple[current] = true;
        }
        for (int next : neighbors.get(current)) {
            if (next != father) {
                getSubTreeHasApple(current, next);
                subTreeHasApple[current] |= subTreeHasApple[next];
            }
        }
    }
}
