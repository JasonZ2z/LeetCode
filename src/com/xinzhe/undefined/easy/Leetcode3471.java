package com.xinzhe.undefined.easy;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2026/08/19
 * Title : 3471. 找出最大的几近缺失整数
 * link : https://leetcode.cn/problems/find-the-largest-almost-missing-integer
 * Level : Easy
 */
public class Leetcode3471 {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        //  只有首尾前k个子数组中存在答案
        //  答案只能是 第一个元素 或者 最后一个元素
        if (k == n) {
            return Arrays.stream(nums).max().getAsInt();
        }
        int[] hash = new int[51];
        //  获取数组中不重复的最大值
        for (int num : nums) {
            hash[num]++;
        }
        if (k == 1) {
            int res = -1;
            for (int i = 0; i < 51; i++) {
                if (hash[i] == 1) {
                    res = i;
                }
            }
            return res;
        }

        //  答案只能在首尾，找一个不重复的最大值就行
        int res = -1;
        if(hash[nums[0]] == 1) {
            res = nums[0];
        }
        if(hash[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }

        return res;
    }
}
