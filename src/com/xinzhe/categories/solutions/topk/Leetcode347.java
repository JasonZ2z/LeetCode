package com.xinzhe.categories.solutions.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/9/7
 * Title : 347. 前 K 个高频元素
 * Description : 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * link : https://leetcode-cn.com/problems/top-k-frequent-elements/
 * Level : Medium
 */
public class Leetcode347 {
    public static void main(String[] args) {}
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)  map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll().getKey();
        }
        return res;
    }
}
