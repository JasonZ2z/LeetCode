package com.xinzhe.contest.weekly.season05.weekly220;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/12/20
 * Title : 1695. 删除子数组的最大得分
 * Description : 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。返回 只删除一个 子数组可获得的 最大得分 。
 *              如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是a 的一个子数组。
 * link : https://leetcode-cn.com/problems/maximum-erasure-value
 * Level : Medium
 */
public class Leetcode_weekly_22002 {
    public static void main(String[] args) {
        Leetcode_weekly_22002 lc = new Leetcode_weekly_22002();
        int[] arr = {5,2,1,2,5,2,1,2,5};
        System.out.println(lc.maximumUniqueSubarray(arr));
    }
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int[] pre = new int[n + 1];
        for(int i=1; i<=n; i++) pre[i] = pre[i-1] + nums[i-1];

        int i=0, j=0, max = nums[0];
        while ( j < n) {
            if(map.containsKey(nums[j])) {
                max = Math.max(max, pre[j] - pre[i]);
                i = Math.max(i, map.get(nums[j]) + 1);
            }
            map.put(nums[j], j);
            j++;
        }
        max = Math.max(max, pre[n] - pre[i]);
        return max;
    }
}
