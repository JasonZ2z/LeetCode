package com.xinzhe.categories.solutions.towpointers;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/6 19:11
 * Title : 16. 最接近的三数之和
 * Description : 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *              返回这三个数的和。假定每组输入只存在唯一答案。
 *              例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *              与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * link : https://leetcode-cn.com/problems/3sum-closest
 * Level : Medium
 */
public class Leetcode016 {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(threeSumClosest(arr, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length <= 2) return 0;
        Arrays.sort(nums);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int p = i+1, q = nums.length-1;
            while(p < q){
                int sum = nums[p] + nums[i] + nums[q];
                if(sum == target){
                    return sum;
                } else if(sum < target){
                    a = Math.min(target-sum, a);
                    p++;
                } else {
                    b = Math.min(sum-target, b);
                    q--;
                }
            }
        }
        return a > b ? target +b : target -a;
    }
}
