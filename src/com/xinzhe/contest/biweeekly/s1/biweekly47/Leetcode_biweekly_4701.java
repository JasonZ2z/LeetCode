package com.xinzhe.contest.biweeekly.s1.biweekly47;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/03/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4701 {
    public static void main(String[] args) {
        Leetcode_biweekly_4701 lc = new Leetcode_biweekly_4701();
        int[] arr = {2, 4, 9, 3};
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < points.length ; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                int cur = helper(x, y, points[i][0], points[i][1]);
                if(cur < min) {
                    min = cur;
                    map.put(cur, i);
                }
            }
        }
        if(min == Integer.MAX_VALUE) return  -1;
        return map.get(min);
    }

    private int helper (int x, int y, int i, int j) {
        return Math.abs(x - i) + Math.abs(y - j);
    }
}