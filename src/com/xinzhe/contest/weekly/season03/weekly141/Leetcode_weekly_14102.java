package com.xinzhe.contest.weekly.season03.weekly141;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/8/20
 * Title :
 * Description :
 * link :
 * Level :
 */

public class Leetcode_weekly_14102 {
    public static void main(String[] args) {
        Leetcode_weekly_14102 lc = new Leetcode_weekly_14102();
    }
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        int n = values.length;

        for(int i=0; i<n; i++) {
            map.computeIfAbsent(labels[i], x -> new PriorityQueue<>((a, b) -> b-a)).add(values[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (PriorityQueue<Integer> value : map.values()) {
            for (int i = 0; i < use_limit; ++i) {
                if(!value.isEmpty()) {
                    res.add(value.poll());
                }
            }
        }
        res.sort(Integer::compareTo);
        int j = 0;
        int ans = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            if(j < num_wanted) {
                ans += res.get(i);
            } else {
                break;
            }
        }
        return ans;

    }
}
