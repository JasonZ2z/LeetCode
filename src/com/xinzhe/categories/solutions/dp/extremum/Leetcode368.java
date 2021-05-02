package com.xinzhe.categories.solutions.dp.extremum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2021/04/23
 * Title : 368. 最大整除子集
 * Description : 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 *              answer[i] % answer[j] == 0 ，或 answer[j] % answer[i] == 0  如果存在多个有效解子集，返回其中任何一个均可。
 * link : https://leetcode-cn.com/problems/largest-divisible-subset
 * Level : Medium
 */
public class Leetcode368 {
    //先确定长度，在倒推元素
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        int max = 1;
        int maxIndex = 0;
        for(int i=1; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[maxIndex]);
        if(max == 1) return res;
        int pre = maxIndex;
        for (int i = maxIndex - 1; i >= 0 && max > 0; i--) {
            if(nums[pre] % nums[i] == 0 && dp[i] == max - 1){
                max--;
                res.add(0, nums[i]);
                pre = i;
            }
        }
        return res;
    }
}
