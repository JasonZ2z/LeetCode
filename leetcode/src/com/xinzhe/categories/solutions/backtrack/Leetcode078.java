package com.xinzhe.categories.solutions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/4 18:55
 * Title : 78. 子集
 * Description : 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * link : https://leetcode-cn.com/problems/subsets/
 * Level : Medium
 */
public class Leetcode078 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums).toString());
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] nums, ArrayList<Integer> list, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, list, i+1);
            list.remove(list.size() -1);
        }
    }
}
