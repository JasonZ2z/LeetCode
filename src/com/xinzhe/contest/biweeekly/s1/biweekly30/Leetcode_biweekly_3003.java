package com.xinzhe.contest.biweeekly.s1.biweekly30;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/7/11
 * Title : 1509. 三次操作后最大值与最小值的最小差
 * Description : 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个元素并将它改成任意值。请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 * link : https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 * Level : Medium
 */
public class Leetcode_biweekly_3003 {
    public static void main(String[] args) {
        Leetcode_biweekly_3003 lc = new Leetcode_biweekly_3003();
        int[] arr = {53,60,100,85,16,68,64,31,37,78};
        System.out.println(lc.minDifference(arr));
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) return 0;
        Arrays.sort(nums);
        int x = Math.min(nums[n-1] - nums[3], nums[n-2]- nums[2]);
        int y = Math.min(nums[n-3] - nums[1] , nums[n-4] - nums[0]);
        return Math.min(x,y);
    }
}
