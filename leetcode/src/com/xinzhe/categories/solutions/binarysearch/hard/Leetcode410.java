package com.xinzhe.categories.solutions.binarysearch.hard;

/**
 * @Author Xin
 * @create 2020/4/26 22:33
 * Title : 410. 分割数组的最大值
 * Description : 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 *              设计一个算法使得这 m 个子数组各自和的最大值最小。
 * link : https://leetcode-cn.com/problems/split-array-largest-sum/
 * Level : Hard
 */
public class Leetcode410 {
    public static void main(String[] args) {
        Leetcode410 lc = new Leetcode410();
        int[] arr = {1, 2147483647};
        System.out.println(lc.splitArray(arr, 2));
    }
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(left, num);
        }
        while(left < right) {
            long mid = left + ((right - left)>>1);
            if(helper(nums, m,  mid)){
                right = mid;
            } else {
                left = mid+1 ;
            }
        }
        return (int)left;
    }

    private boolean helper(int[] nums, int m, long mid) {
        long sum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                m--;
                sum = num;
            } else {
                sum += num;
            }
        }
        return m > 0;
    }
}
