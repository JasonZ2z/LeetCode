package com.xinzhe.categories.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/4 22:26
 * Title : 46. 全排列
 * Description : 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * link : https://leetcode-cn.com/problems/permutations/
 * Level : Medium
 */
public class Leetcode046 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums).toString());
    }
    private static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        traceback(nums, new ArrayList<>());
        return result;

    }

    private static void traceback(int[] nums, ArrayList<Integer> track) {
        if(track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if(track.contains(num)){
                continue;
            }
            track.add(num);
            traceback(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
