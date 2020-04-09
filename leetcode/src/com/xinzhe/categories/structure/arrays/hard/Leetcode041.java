package com.xinzhe.categories.structure.arrays.hard;

/**
 * @author Xin
 * @create 2020/4/9 21:37
 * Title : 41. 缺失的第一个正数
 * Description : 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * link : https://leetcode-cn.com/problems/first-missing-positive/
 * Level : Hard
 */

//todo undo
public class Leetcode041 {
    public static void main(String[] args) {
        int[] nums = {2147483647};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        if(max <= 0) return 1;
        boolean[] tmp = new boolean[max];
        for (int num : nums) {
            if (num > 0) {
                tmp[num-1] = true;
            }
        }
        for (int i = 0; i < max; ++i) {
            if(!tmp[i]) return ++i;
        }
        return max+1;
    }
}
