package com.xinzhe.order.day00;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/2/25 16:10
 * Title : 1248. 统计「优美子数组」
 * Description : 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * link : https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * Level : medium
 */
public class Leetcode1248 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        System.out.println(numberOfSubarrays(nums, 1));
        System.out.println(numberOfSubarrays2(nums, 1));
    }

    //超时
    public static int numberOfSubarrays(int[] nums, int k) {
        if(nums == null || nums.length < k) return 0;
        if(nums.length == k){
            for (int num : nums) {
                if (num % 2 == 0) return 0;
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                if(tmp < k){
                    if(nums[j] % 2 != 0){
                        tmp++;
                        if(tmp == k) {
                            count++;
                        }
                    }
                } else if( tmp == k){
                    if(nums[j] % 2 == 0){
                        count++;
                    } else {
                        tmp++;
                    }

                } else {
                    break;
                }
            }
        }
        return count;
    }
    // 滑动窗口
    public static int numberOfSubarrays2(int[] nums, int k){
        int len = nums.length;
        int res = 0;
        int feed = 0;

        int[] arr = new int[len+2];
        for (int i = 0; i < len; i++) {
            if((nums[i] & 1 ) == 1){
                arr[++feed] = i;
            }
        }
        arr[0] = -1;
        arr[feed + 1] = len;

        for (int i = 1; i + k < feed+2; i++) {
            res += (arr[i] - arr[i - 1]) * (arr[i + k] - arr[i + k - 1]);
        }
        return res;
    }
}
