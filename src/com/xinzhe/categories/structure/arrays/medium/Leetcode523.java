package com.xinzhe.categories.structure.arrays.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/2/25 16:16
 * Title : 523. 连续的子数组和
 * Description : 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 *              其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * link : https://leetcode-cn.com/problems/continuous-subarray-sum
 * Level : Medium
 */
//todo need to review
public class Leetcode523 {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        //int[] nums = {1,1};
        System.out.println(checkSubarraySum(nums, -1));
        System.out.println(checkSubarraySum2(nums, -1));
        System.out.println(checkSubarraySum1(nums, -1));
    }

    //1) 当nums中有连续0, 无论k为何值都是正确的;
    //2) 除情况1之外出现k为0都是错误的;
    //3) k为负数也是可能的, 但是要将其变为对应正数来求mod.
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2 ) return false;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0 && nums[i+1] == 0 ){
                return true;
            }
        }
        if(k == 0) return false;
        if(k < 0) k = -k;

        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
            if(sums[i] % k == 0) return true;
            for(int j = i-2; j >= 0; j--) {
              if((sums[i] - sums[j]) % k == 0){
                  return  true;
                }
            }
        }
        return false;
    }

    /**
     * sum[0~x] = m*k + mod_x;
     * sum[0~y] = n*k + mod_y;
     * 如果mod_x == mod_y且y-x > 1
     *
     * map中初始化<0,-1>,
     * 其原因在于解决到达某个i时sum恰好可以整除k的情况,
     * 选择-1的原因是要求连续子数组长度大于等于2, 这样可以避免第一个数字为0的情况
     */
    public static boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        if (k == 0) return false;
        if (k < 0) k = -k;
        Map<Integer, Integer> map = new HashMap<>(k);
        map.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int mod = sum % k;
            if(map.containsKey(mod)) {
                if(i - map.get(mod) > 1) {
                    return true;
                }
            } else{
                map.put(mod, i);
            }
        }
        return false;
    }
    //暴力破解
    public static boolean checkSubarraySum2(int[] nums, int k) {
        if(nums == null || nums.length < 2 ) return false;
        int[] sums = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+2; j <= nums.length; j++) {
                int tmp = sums[j] - sums[i];
                if(k == 0) {
                    if(tmp == 0) return true;
                } else {
                    if(tmp % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
