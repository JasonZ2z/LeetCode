package com.xinzhe.categories.solutions.dichotomies;

/**
 * @Author Xin
 * @create 2020/3/31 21:37
 * Title : 287. 寻找重复数
 * Description : 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * link : https://leetcode-cn.com/problems/find-the-duplicate-number
 * Level : Medium
 */
public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}
