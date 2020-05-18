package com.xinzhe.contest.weekly.weekly178;

/**
 * @Author Xin
 * @create 2020/5/15
 * Title : 1365. 有多少小于当前数字的数字
 * Description : 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * link : https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * Level : Easy
 * Comment 178周赛01
 */

public class Leetcode_weekly_17801 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j != i && j < n; ++j) {
                if (nums[j] < nums[i]) res[i]++;
            }
        }
        return res;
    }
}
