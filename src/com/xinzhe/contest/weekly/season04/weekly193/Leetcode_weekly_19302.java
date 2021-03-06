package com.xinzhe.contest.weekly.season04.weekly193;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/6/14
 * Title : 1481. 不同整数的最少数目
 * Description : 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 * link : https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals/
 * Level : Medium
 * Comment 193周赛02
 */
public class Leetcode_weekly_19302 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+ 1);
        }
        List<Integer> res = map.values().stream().sorted(Integer::compareTo).collect(Collectors.toList());
        int count = res.size();
        for (Integer re : res) {
            if(k <= 0) return count;
            if(k >= re) {
               count--;
            }
            k -= re;
        }
        return count;
    }
}
