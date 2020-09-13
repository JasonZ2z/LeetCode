package com.xinzhe.contest.weekly.season05.weekly206;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20602 {
    public static void main(String[] args) {
        Leetcode_weekly_20602 lc = new Leetcode_weekly_20602();
        int[][] arr = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] test = {{1,3}, {0,2}};
        System.out.println(lc.unhappyFriends(4, arr, test));
    }


    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        int count = 0;
        for (int[] pair : pairs) {
            int from = pair[0];
            int to = pair[1];

            count += getCount(preferences, map, from, to) ? 1 : 0;
            count += getCount(preferences, map, to, from) ?  1 : 0;
        }
        return count;
    }

    private boolean getCount(int[][] preferences, Map<Integer, Integer> map, int from, int to) {
        for (int u : preferences[from]) {
            if(u != to) {
                int v = map.get(u);
                for (int x : preferences[u]) {
                    if(x == from) {
                        return true;
                    }else if( x == v){
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return false;
    }
}
