package com.xinzhe.categories.solutions.dp.subsequence;

/**
 * @author Xin
 * @date 2020/3/9 21:23
 * Title : 53. 最大子序和
 * Description : 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * link : https://leetcode-cn.com/problems/maximum-subarray
 * Level : Easy
 */
public class Leetcode053 {
    //dp
    public int maxSubArray(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i <n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }

        return res;
    }

    //分治 线段树
    class Array{
        int lsum;
        int rsum;
        int msum;
        int isum;

        public Array(int lsum, int rsum, int msum, int isum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
            this.isum = isum;
        }
    }

    public Array build(int[] arr, int l, int r){
        if(l == r) {
            return new Array(arr[l],arr[l],arr[l],arr[l]);
        } else {
            int mid = l + (r - l)/2;
            Array left = build(arr, l, mid);
            Array right = build(arr, mid + 1, r);
            return merge(left, right);
        }
    }

    private Array merge(Array left, Array right) {
        int isum = left.isum + right.isum;
        int lsum = Math.max(left.lsum, left.isum+right.lsum);
        int rsum = Math.max(right.rsum, right.isum+left.rsum);
        int msum = Math.max(Math.max(left.msum, right.msum), left.rsum+right.lsum);
        return new Array(lsum, rsum, msum, isum);
    }

    public int maxSubArray2(int[] nums){
        if(nums.length==0) return 0;
        Array arr = build(nums, 0, nums.length - 1);
        return arr.msum;
    }
}
