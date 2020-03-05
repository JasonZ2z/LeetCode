package com.xinzhe.categories.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/3/4 18:55
 * Title : 90. 子集 II
 * Description : 给定一组可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * link : https://leetcode-cn.com/problems/subsets-ii/
 * Level : Medium
 */
public class SubsetsⅡ {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(subsetsWithDup(nums).toString());
    }
    static Set<List<Integer>> result = new HashSet<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        traceback(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private static void traceback(int[] nums, int start, ArrayList<Integer> track) {
        ArrayList<Integer> list = new ArrayList<>(track);
        list.sort(Integer::compareTo);
        result.add(list);

        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            traceback(nums, i+1, track);
            track.remove(track.size()-1);
        }
    }
}
