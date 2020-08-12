package com.xinzhe.contest.weekly.season04.weekly186;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @create 2020/4/24
 * Title : 1425. 带限制的子序列和
 * Description : 给你一个整数数组 nums 和一个整数 k ，请你返回 非空 子序列元素和的最大值，子序列需要满足：
 *              子序列中每两个 相邻 的整数 nums[i] 和 nums[j] ，它们在原数组中的下标 i 和 j 满足 i < j 且 j - i <= k 。
 *              数组的子序列定义为：将数组中的若干个数字删除（可以删除 0 个数字），剩下的数字按照原本的顺序排布。
 * link : https://leetcode-cn.com/problems/constrained-subset-sum
 * Level : Hard
 * Comment : 186周赛04
 */
public class Leetcode_weekly_18604 {
    public static void main(String[] args) {
        Leetcode_weekly_18604 lc = new Leetcode_weekly_18604();
       // int[] nums = {10,2,-10,5,20};
        int[] nums = {10,-2,-10,-5,20};
        System.out.println(lc.constrainedSubsetSum1(nums, 2));
        System.out.println(lc.constrainedSubsetSum(nums, 2));
    }
    public int constrainedSubsetSum1(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] =nums[0];
        for (int i = 1; i < n; ++i) {
            if(nums[i] > 0) flag = true;
            max = Math.max(nums[i], max);
            for(int j = k; j > 0; --j) {
                if(i-j >= 0) {
                    int tmp = dp[i-j];
                    for (int l = i-j+1; l <= i ; ++l) {
                        tmp += nums[l];
                    }
                    dp[i] = Math.max(dp[i] , tmp);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        if(!flag) return max;
        return Math.max(dp[n-1], max);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int res = Integer.MIN_VALUE, n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int max = Math.max(queue.isEmpty() ? 0 : nums[queue.peekFirst()], 0);
            int num = nums[i] + max;
            res = Math.max(res, num);
            nums[i] = num;
            // System.out.println(i + " " + num + " " + res);
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            while (queue.peekFirst() - (i - 1) > k) {
                queue.pollFirst();
            }
        }
        return res;
    }

    public int constrainedSubsetSum2(int[] nums, int k) {
        int n = nums.length;

        Deque<int[]> q = new LinkedList<>();
        int maxi = - 1 << 30, run = 0;

        for(int i = 0; i < n; i++)
        {
            // for(int[] qq : q) System.out.println(Arrays.toString(qq));
            int cur = nums[i];
            while(!q.isEmpty() && q.peekFirst()[0] + k < i) q.pollFirst();
            if(!q.isEmpty()) cur += Math.max(0, q.peekFirst()[1]);
            maxi = Math.max(maxi, cur);
            while(!q.isEmpty() && q.peekLast()[1] < cur) q.pollLast();
            // if(q.isEmpty())
            q.offer(new int[]{i, cur});
        }

        return maxi;
    }
}
