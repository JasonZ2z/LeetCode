package com.xinzhe.contest.weekly.season05.weekly224;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2021/01/17
 * Title : 1726. 同积元组
 * Description : 给你一个由 不同 正整数组成的数组 nums ，请你返回满足a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * link : https://leetcode-cn.com/problems/tuple-with-same-product
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
