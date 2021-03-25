package com.xinzhe.contest.weekly.season05.weekly232;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23202 {
    public static void main(String[] args) {
        Leetcode_weekly_23202 lc = new Leetcode_weekly_23202();
    }

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        return map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).findFirst().get().getKey();
    }
}
