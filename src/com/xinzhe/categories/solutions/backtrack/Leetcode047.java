package com.xinzhe.categories.solutions.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/3/4 22:34
 * Title : 47. 全排列 II
 * Description : 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * link : https://leetcode-cn.com/problems/permutations-ii/
 * Level : Medium
 */

//todo undone
public class Leetcode047 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(permuteUnique(nums).toString());
    }
    private static Set<List<Integer>> result = new HashSet<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        traceback(nums, new ArrayList<>());
        return new ArrayList<>(result);

    }

    private static void traceback(int[] nums, ArrayList<Integer> track) {
        if(track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            track.add(num);
            traceback(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
