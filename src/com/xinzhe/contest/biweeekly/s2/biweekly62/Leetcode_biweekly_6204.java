package com.xinzhe.contest.biweeekly.s2.biweekly62;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2021/10/02
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6204 {
    public static void main(String[] args) {
        Leetcode_biweekly_6204 lc = new Leetcode_biweekly_6204();
        int[] arr = {22,4,-25,-20,-15,15,-16,7,19,-10,0,-13,-14};
        System.out.println(lc.waysToPartition(arr, -33));
    }
    public int waysToPartition(int[] nums, int k) {
        long sum = nums[0], max = 0;
        HashMap<Long, TreeMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 1; i < nums.length; sum += nums[i++]) {
            map.computeIfAbsent(sum, t -> new TreeMap<>()).put(i, map.get(sum).size());
        }
        for (int i = 0; i < nums.length; i++) {
            if ((sum + k - nums[i]) % 2 == 0) {
                Map.Entry<Integer, Integer> left = map.getOrDefault((sum + k - nums[i]) / 2, new TreeMap<>())
                        .floorEntry(i),
                        right = map.getOrDefault((sum - k + nums[i]) / 2, new TreeMap<>()).higherEntry(i);
                max = Math.max(max, (left == null ? 0 : left.getValue() + 1) + (right == null ? 0
                        : map.getOrDefault((sum - k + nums[i]) / 2, new TreeMap<>()).size() - right.getValue()));
            }
        }
        return (int) Math.max(max, sum % 2 > 0 ? 0 : map.getOrDefault(sum / 2, new TreeMap<>()).size());
    }
}