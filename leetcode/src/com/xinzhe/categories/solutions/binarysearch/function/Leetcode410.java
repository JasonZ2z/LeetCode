package com.xinzhe.categories.solutions.binarysearch.function;

import java.util.Arrays;

/**
 * @author Xin
 * @create 2020/4/13 18:39
 * Title : 410. 分割数组的最大值
 * Description : 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *          注意:数组长度 n 满足以下条件:
 *              1 ≤ n ≤ 1000
 *              1 ≤ m ≤ min(50, n)
 * link : https://leetcode-cn.com/problems/split-array-largest-sum
 * Level : Hard
 */

public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        if(n == 1 && m == 1) return nums[0];
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).sum();
        if(n == m) return nums[n-1];
        long left = nums[n-1], right = sum;
        while(left < right){
            long mid = left + ((right - left) >> 1);
            if(add(mid, nums) <= m){
                right = mid;
            } else {
                left = mid +1;
            }

        }
        return (int) left;
    }

    private int add(long mid, int[] nums) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if(sum > mid) {
                count++;
                sum = num;
            }
        }
        return count;
    }
}
