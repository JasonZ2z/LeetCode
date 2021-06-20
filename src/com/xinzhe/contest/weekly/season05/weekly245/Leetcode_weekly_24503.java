package com.xinzhe.contest.weekly.season05.weekly245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/06/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24503 {
    public static void main(String[] args) {
        Leetcode_weekly_24503 lc = new Leetcode_weekly_24503();

    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < triplets.length; i++) {
            for (int j = 0; j < triplets[i].length; j++) {
                if(triplets[i][j] == target[j]) {
                    map.computeIfAbsent(target[j], a -> new ArrayList<>()).add(i);
                }
            }
        }

        if(map.get(target[0]) == null || map.get(target[1]) == null || map.get(target[2]) == null) return false;

        boolean f0 = false, f1 = false, f2 = false;
        for (int i : map.get(target[0])) {
            f0 = true;
            for (int j = 0; j < 3; ++j) {
                f0 &= triplets[i][j] <= target[j];
            }
            if(f0) break;
        }
        for (int i : map.get(target[1])) {
            f1 = true;
            for (int j = 0; j < 3; ++j) {
                f1 &= triplets[i][j] <= target[j];
            }
            if(f1) break;
        }
        for (int i : map.get(target[2])) {
            f2 = true;
            for (int j = 0; j < 3; ++j) {
                f2 &= triplets[i][j] <= target[j];
            }
            if(f2) break;
        }
        return f0 & f1 & f2;

    }
}
