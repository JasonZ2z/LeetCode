package com.xinzhe.categories.solutions.topk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/9/7
 * Title : 347. 前 K 个高频元素
 * Description : 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * link : https://leetcode-cn.com/problems/top-k-frequent-elements/
 * Level : Medium
 */
public class Leetcode347 {

    //小根堆 O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = Arrays.stream(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> counter.get(a) - counter.get(b));
        counter.forEach((num, cnt) -> {
            queue.offer(num);
            if(queue.size() > k) queue.poll();
        });
        int[] res = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }

    // 二叉搜索树 O(nlogk)
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> counter = Arrays.stream(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // <times, List<Index>>
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if(count < k) {
                treeMap.computeIfAbsent(cnt, ArrayList::new).add(num);
                count++;
            } else {
                Map.Entry<Integer, List<Integer>> first = treeMap.firstEntry();
                if(cnt > first.getKey()) {
                    treeMap.computeIfAbsent(cnt, ArrayList::new).add(num);
                    List<Integer> list = first.getValue();
                    if(list.size() == 1) {
                        treeMap.pollFirstEntry();
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (List<Integer> list : treeMap.values()) {
            for (int num : list) {
                res[i++] = num;
            }
        }
        return res;
    }

    //计数排序 O(n)
    public int[] topKFrequent3(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> counter = Arrays.stream(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        List<Integer>[] freq = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            freq[i] = new ArrayList<>();
        }
        counter.forEach((num, cnt) -> freq[cnt].add(num));
        int[] res = new int[k];
        int i = 0;
        for(int f = n; f >= 1; --f) {
            for (int num : freq[f]) {
                res[i++] = num;
                if(i == k) return res;
            }
        }
        return res;
    }
}
