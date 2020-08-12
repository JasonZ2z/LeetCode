package com.xinzhe.categories.structure.arrays.medium;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/4/22
 * Title : 31. 下一个排列
 * Description : 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *      1,2,3 → 1,3,2
 *      3,2,1 → 1,2,3
 *      1,1,5 → 1,5,1
 * link : https://leetcode-cn.com/problems/next-permutation
 * Level : Medium
 */

public class Leetcode031 {
    public static void main(String[] args) {
        //int[] nums = {1,2,3};
        //int[] nums = {1,1,5,0,1};
        int[] nums = {2,3,1,3,3};
        nextPermutation(nums);
    }
    //类似暴力
    //先找到可交换的位置
    //找到比奇大的最小值
    //剩余部分排序即可
    //注意相同值得处理
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) return;

        boolean flag = false;
        int k = n-1;
        while (k >= 1) {
            if(nums[k-1] < nums[k]){
                flag = true;
                int shift = Integer.MAX_VALUE;
                int sec = 0;
                //可以用二分优化
                for(int i = n-1; i > k-1; --i) {
                  if(nums[i] > nums[k-1]) {
                      if(shift > nums[i] - nums[k-1]) {
                          shift = nums[i] - nums[k-1];
                          sec = i;
                      }
                  }
                }
                swap(nums, k-1, sec);
                for (int i = 0; i < (n-k)/2; ++i) {
                    swap(nums, i+k, n-1-i);
                }
                break;
            }
            k--;
        }

        if(!flag){
            for (int i = 0; i < n / 2; ++i) {
                swap(nums, i, n-1-i);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
