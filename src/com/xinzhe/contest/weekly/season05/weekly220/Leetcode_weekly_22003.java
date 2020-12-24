package com.xinzhe.contest.weekly.season05.weekly220;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/12/20
 * Title : 1696. 跳跃游戏 VI
 * Description : 给你一个下标从 0 开始的整数数组 nums和一个整数 k。
 *              一开始你在下标0处。每一步，你最多可以往前跳k步，但你不能跳出数组的边界。也就是说，你可以从下标i跳到[i + 1， min(n - 1, i + k)]包含 两个端点的任意位置。
 *              你的目标是到达数组最后一个位置（下标为 n - 1），你的 得分为经过的所有数字之和。请你返回你能得到的 最大得分。
 * link : https://leetcode-cn.com/problems/jump-game-vi
 * Level : Medium
 */
public class Leetcode_weekly_22003 {
    public static void main(String[] args) {
        Leetcode_weekly_22003 lc = new Leetcode_weekly_22003();
        int[] arr = {1,-1,-2,4,-7,3};
        System.out.println(lc.maxResult(arr, 2));
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n && j - i <= k ; j++) {
                int x = dp[i] + nums[j];
                dp[j] = Math.max(dp[j], x);
                if(dp[j] >= dp[i]) break;
            }
        }
        return dp[n-1];
    }

    public int maxResult2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int res = nums[0];
        queue.offer(new int[]{nums[0], 0});
        for (int i = 1; i < n; ++i) {
            while (i - queue.peek()[1] > k) queue.poll();
            res = queue.peek()[0] + nums[i];
            queue.offer(new int[]{res, i});
        }
        return res;
    }
}
