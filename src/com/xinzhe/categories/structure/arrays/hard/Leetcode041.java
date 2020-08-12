package com.xinzhe.categories.structure.arrays.hard;

/**
 * @author Xin
 * @create 2020/4/9 21:37
 * Title : 41. 缺失的第一个正数
 * Description : 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * link : https://leetcode-cn.com/problems/first-missing-positive/
 * Level : Hard
 */

//todo need to review
public class Leetcode041 {
    public static void main(String[] args) {
        int[] nums = {2147483647};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int value : nums) {
            if (value == 1) {
                flag = true;
                break;
            }
        }
        //不含1
        if(!flag) return 1;
        //含1
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != i+1 && nums[nums[i] -1] != nums[i]){
                int tmp = nums[nums[i] -1];
                nums[nums[i] -1] = nums[i] ;
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
