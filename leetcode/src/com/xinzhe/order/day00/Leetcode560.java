package com.xinzhe.order.day00;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/2/24 14:37
 * Title : 560. 和为K的子数组
 * Description : 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *              输入:nums = [1,1,1], k = 2
 *              输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * link : https://leetcode-cn.com/problems/subarray-sum-equals-k
 */
public class Leetcode560 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(subarraySum(nums, 1));
        System.out.println(subarraySum1(nums, 1));
        System.out.println(subarraySum2(nums, 1));
    }
    // 暴力破解
    public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和：
     *     sum[i]表示num[0:i]的子数组和，那么num[i:j]的和等于sum[j] - sum[i]
     *     两层循环遍历sum数组检查 sum[j] - sum[i] == k
     */
    public static int subarraySum1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            if(sum == k){
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(sums[i] - sums[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Hash表思路：
     * 存储所有可能的索引的累积总和以及相同累加和发生的次数
     */
    public static int subarraySum2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int tmp = sum - k;
            if(map.containsKey(tmp)){
                count += map.get(tmp);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
