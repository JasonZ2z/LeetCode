package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/3/4 18:55
 * Title : 90. 子集 II
 * Description : 给定一组可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * link : https://leetcode-cn.com/problems/subsets-ii/
 * Level : Medium
 */
public class Leetcode090 {

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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), false);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, boolean flag){
        if(index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, index+1, list, false);
        if(!flag && index > 0 && nums[index] == nums[index - 1]) return;
        list.add(nums[index]);
        dfs(nums, index + 1, list, true);
        list.remove(list.size()-1);
    }
}
