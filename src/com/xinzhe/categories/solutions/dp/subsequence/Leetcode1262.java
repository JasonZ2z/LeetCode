package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/11 18:55
 * Title : 1262. 可被三整除的最大和
 * Description : 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * link : https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * Level : Medium
 */
public class Leetcode1262 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4};
        System.out.println(maxSumDivThree(a));
        System.out.println(maxSumDivThree2(a));
    }
    //dp
    public static int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int mod = nums[i - 1] % 3;
            if(mod == 0){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][0]+ nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][1]+ nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][2]+ nums[i-1]);
            }
            if(mod == 1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+ nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+ nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+ nums[i-1]);
            }
            if(mod == 2){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+ nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+ nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]+ nums[i-1]);
            }
        }
        return dp[n][0];
    }

    //数学方法
    public static int maxSumDivThree2(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = Arrays.stream(nums).sum();
        int mod = sum % 3;
        if (mod == 0) return sum;

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int num : nums) {
            if (num % 3 == 1) a.add(num);
            if (num % 3 == 2) b.add(num);
        }
        Collections.sort(a);
        Collections.sort(b);
        if(mod == 1){
            if(a.size() != 0 && b.size() < 2) return sum-a.get(0);
            if(b.size() >= 2 && a.size() == 0) return sum -b.get(0) -b.get(1);
            if(a.size() > 0){
                int tmp = b.get(0) + b.get(1);
                sum -= tmp < a.get(0) ? tmp: a.get(0);
                return sum;
            }
        }
        if(mod == 2){
            if(a.size() <= 1 && b.size() > 0) return sum-b.get(0);
            if(a.size() >= 2 && b.size() == 0) return sum -a.get(0) -a.get(1);
            if(a.size() >= 2){
                int tmp = a.get(0) + a.get(1);
                sum -= tmp < b.get(0) ? tmp: b.get(0);
                return sum;
            }
        }
        return 0;
    }
}
