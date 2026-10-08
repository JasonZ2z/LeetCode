package com.xinzhe.undefined.medium;

/**
 * @author Xin
 * @date 2026/09/23
 * Title : 1658. 将 x 减到 0 的最小操作数
 * link : https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 * Level : Medium
 */
public class Leetcode1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum == x) return n;
        if(sum < x) return -1;
        int res = -1, win = 0, target = sum - x;
        for(int left = 0, right = 0; right < n; right++){
            win += nums[right];
            while(left <= right && win > target) {
                win -= nums[left++];
            }
            if(win == target) {
                res = Math.max(res, right - left + 1);
            }
        }
        if(res == -1) return -1;
        return n - res;
    }
}
