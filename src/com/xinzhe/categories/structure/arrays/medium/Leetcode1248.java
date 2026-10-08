package com.xinzhe.categories.structure.arrays.medium;

import java.util.*;

/**
 * @author Xin
 * @date 2020/2/25 16:10
 * Title : 1248. 统计「优美子数组」
 * Description : 给你一个整数数组 nums 和一个整数 k。
 *      如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *      请返回这个数组中「优美子数组」的数目。
 * link : https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * Level : medium
 */
public class Leetcode1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, res = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                pre++;
            }
            if (pre >= k) {
                res += map.getOrDefault(pre - k, 0);
            }
            map.merge(pre, 1, Integer::sum);
        }
        return res;
    }
}
