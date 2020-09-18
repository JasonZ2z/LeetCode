package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/4 22:34
 * Title : 47. 全排列 II
 * Description : 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * link : https://leetcode-cn.com/problems/permutations-ii/
 * Level : Medium
 */

//todo need to review
public class Leetcode047 {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Leetcode047 lc = new Leetcode047();
        System.out.println(lc.permuteUnique(nums).toString());
    }
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums,  used, new ArrayList<>());
        return result;

    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> track) {
        if(track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])  continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, track);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}
