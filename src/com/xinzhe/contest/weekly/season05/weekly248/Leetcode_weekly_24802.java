package com.xinzhe.contest.weekly.season05.weekly248;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/07/04
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24802 {
    public static void main(String[] args) {
        Leetcode_weekly_24802 lc = new Leetcode_weekly_24802();
        int[] dist = {3,5,7,4,5};
        int[] speed = {2,3,6,3,2};
       System.out.println(lc.eliminateMaximum(dist,speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < dist.length; i++) {
            int var = dist[i] % speed[i] == 0 ? dist[i] / speed[i] : dist[i] / speed[i] + 1;
            map.put(var, map.getOrDefault(var, 0) + 1);
        }
        if(map.getOrDefault(0, 0) > 1) return 1;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += map.getOrDefault(i, 0);
            if(count > i) {
                return i;
            }
        }
        return n;
    }
}
