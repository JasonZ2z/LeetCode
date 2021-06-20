package com.xinzhe.contest.weekly.season05.weekly244;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/06/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24402 {
    public static void main(String[] args) {
        Leetcode_weekly_24402 lc = new Leetcode_weekly_24402();

    }
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        int res = 0;
        while (queue.size() > 1) {
            Map.Entry<Integer, Integer> first = queue.poll();
            Map.Entry<Integer, Integer> next = queue.poll();
            res += first.getValue();
            queue.offer(Map.entry(next.getKey(), next.getValue() + first.getValue()));
        }
        return res;
    }
}
