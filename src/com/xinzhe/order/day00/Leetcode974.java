package com.xinzhe.order.day00;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/2/25 11:11
 * Title : 974. 和可被 K 整除的子数组
 * Description : 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * link : https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * Level : medium
 */
public class Leetcode974 {

    public static void main(String[] args) {
        int[] nums = {2,-2,2,-4};
        System.out.println(subarraysDivByK(nums, 6));
        System.out.println(subarraysDivByK2(nums, 6));
    }
    // 解题思路与560类似
    // 难点： 负数计算模 ((sum % K) + K) % K
    public static int subarraysDivByK2(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            if(sum % k == 0){
                count++;
            }
        }
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int i : sums) {
            int tmp = ((i % k) + k ) % k;
            if (map.containsKey(tmp)) {
                count += map.get(tmp);
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return  count;
    }

    // 超出时间限制
    public static int subarraysDivByK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            if(sum % k == 0){
                count++;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for(int j = i-1; j >= 0; j--) {
              if((sums[i] - sums[j]) % k == 0 ){
                  count++;
              }
            }
        }
        return count;
    }
}
