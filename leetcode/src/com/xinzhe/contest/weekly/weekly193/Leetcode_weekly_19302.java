package com.xinzhe.contest.weekly.weekly193;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Xin
 * @create 2020/6/14
 * Title :
 * Description :
 * link :
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
