package com.xinzhe.categories.structure.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/4/10 21:37
 * Title : 448. 找到所有数组中消失的数字
 * Description : 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *              找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *              您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * link : https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * Level : Medium
 */

//这道题需要交换数据
public class Leetcode448 {

    //0,1,2,3,4,5,6
    //1,4,3,4,2,3,5
    //1,3,5,4,1,3,5
    //1,3,1,4,5,3,5
    //1,3,1,4,5,
    public static void main(String[] args) {
        int[] num = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(num));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if(n < 2) return res;
        for (int i = 0; i < n; ++i) {
            while(i != nums[i] -1 && nums[nums[i] -1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
            System.out.println(Arrays.toString(nums));
        }
        for (int i = 0; i < n; ++i) {
            if(nums[i] - 1 != i){
                res.add(i+1);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
