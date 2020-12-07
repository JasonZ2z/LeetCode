package com.xinzhe.contest.weekly.season05.weekly218;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/12/06
 * Title : 1679. K 和数对的最大数目
 * Description : 给你一个整数数组 nums 和一个整数 k 。每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *              返回你可以对数组执行的最大操作数。
 * link : https://leetcode-cn.com/problems/max-number-of-k-sum-pairs
 * Level : Medium
 */
public class Leetcode_weekly_21802 {
    public static void main(String[] args) {
        Leetcode_weekly_21802 lc = new Leetcode_weekly_21802();
        int[] arr = {3,5};
    }
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        Set<Integer> set =  new HashSet<>();
        for (Integer key : map.keySet()) {
            if(set.contains(key)) continue;
            int x = map.get(key);
            int off  = k - key;
            if(key == off) cnt += x/2;
            else {
                cnt += Math.min(x, map.getOrDefault(off, 0));
            }
            set.add(key);
            set.add(off);
        }
        return cnt;
    }
}
