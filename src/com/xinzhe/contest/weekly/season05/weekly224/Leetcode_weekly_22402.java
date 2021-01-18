package com.xinzhe.contest.weekly.season05.weekly224;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/01/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22402 {
    public static void main(String[] args) {
        Leetcode_weekly_22402 lc = new Leetcode_weekly_22402();
        int[] arr = {3,5};
    }
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; ++j) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if(val > 1) {
                res += val * (val - 1) * 4;
            }
        }
        return res;

    }
}
