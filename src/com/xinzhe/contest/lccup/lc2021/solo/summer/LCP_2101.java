package com.xinzhe.contest.lccup.lc2021.solo.summer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/9/11
 * Title :
 * Description :
 * link :
 */
public class LCP_2101 {
    public static void main(String[] args) {
        LCP_2101 lcp_2101 = new LCP_2101();
    }


    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = source.length, n = source[0].length;
        for (int[] ints : source) {
            for (int j = 0; j < n; ++j) {
                int x = ints[j];
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }
        int count = 0;
        for (int[] ints : target) {
            for (int j = 0; j < n; ++j) {
                int x = ints[j];
                if(map.containsKey(x) && map.get(x) > 0) {
                    map.put(x, map.get(x) - 1);
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
