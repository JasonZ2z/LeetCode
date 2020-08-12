package com.xinzhe.contest.weekly.season04.weekly193;

/**
 * @author Xin
 * @date 2020/6/14
 * Title : 1480. 一维数组的动态和
 * Description : 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。请返回 nums 的动态和。
 * link : https://leetcode-cn.com/problems/running-sum-of-1d-array
 * Level : Easy
 * Comment 193周赛01
 */
public class Leetcode_weekly_19301 {
    public int[] runningSum(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];

        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + arr[i];
        }
        return pre;
    }
}
