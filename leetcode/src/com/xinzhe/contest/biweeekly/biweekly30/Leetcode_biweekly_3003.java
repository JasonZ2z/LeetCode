package com.xinzhe.contest.biweeekly.biweekly30;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/7/11
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_3003 {
    public static void main(String[] args) {
        Leetcode_biweekly_3003 lc = new Leetcode_biweekly_3003();
        int[] arr = {53,60,100,85,16,68,64,31,37,78};
        //int[] arr = {20,66,68,57,45,18,42,34,37,58};
        //int[] arr = {1,5,6,14,15,16};
        //int[] arr = {6,6,0,1,1,4,6};
        //int[] arr = {5,3,2,4};
        //int[] arr = {1,5,0,10,14};
        System.out.println(lc.minDifference(arr));
    }
    // 0 1 5 10 14 14 15

    // 14 14 14 10 14 14      4

    // 5 1 5 10 5 5             5
    // 10 1 5 10 10 10           9
    //

    // 0 1 1 4 6 6 6
    // 1 5 6 14 15
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        Arrays.sort(nums);
        int x = Math.min(nums[n-1] - nums[3], nums[n-2]- nums[2]);
        int y = Math.min(nums[n-3] - nums[1] , nums[n-4] - nums[0]);
        return Math.min(x,y);
    }
}
