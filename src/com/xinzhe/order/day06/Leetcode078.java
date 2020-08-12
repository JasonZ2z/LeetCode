package com.xinzhe.order.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/20 20:54
 * Title : 78. 子集
 * Description : 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * link : https://leetcode-cn.com/problems/subsets/
 * Level : Medium
 */
public class Leetcode078 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {

        if(nums.length == 0) return res;
        helper(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void helper(int[] nums, ArrayList<Integer> track, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            helper(nums, track, i+1);
            track.remove(track.size()-1);
        }

    }
}
