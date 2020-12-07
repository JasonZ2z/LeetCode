package com.xinzhe.categories.structure.linkedlist.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/12/07
 * Title : 862. 和至少为 K 的最短子数组
 * Description : 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。如果没有和至少为 K 的非空子数组，返回 -1 。
 * link : https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 * Level : Hard
 */
//todo need to review
public class Leetcode862 {
    public int shortestSubarray(int[] arr, int K) {
        int pre = 0;
        int min = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            pre = pre + arr[i];
            Map.Entry<Integer, Integer> entry = map.floorEntry(pre - K);
            if(entry != null ) {
                min = Math.min(min, i - entry.getValue());
            }
            while (map.size() > 0 && map.lastKey() > pre) map.pollLastEntry();
            map.put(pre, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
