package com.xinzhe.categories.solutions.dp.robber;

/**
 * @author Xin
 * @date 2020/3/27 19:55
 * Title : 740. 删除与获得点数
 * Description : 给定一个整数数组 nums ，你可以对它进行一些操作。
 *              每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *              开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * link : https://leetcode-cn.com/problems/delete-and-earn
 * Level : Medium
 */

public class Leetcode740 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int[] arr = new int[10001];

        for (int num : nums) {
            arr[num]++;
        }

        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = arr[1];
        for (int i = 2; i <= 10000; ++i) {
            dp[i] = Math.max(dp[i-2] + i * arr[i], dp[i-1]);
        }

        return dp[10000];
    }
}
