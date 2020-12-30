package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/3/11 18:15
 * Title : 491. 递增子序列
 * Description : 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * link : https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Level : Medium
 */

//todo need to review
public class Leetcode491 {
    public static void main(String[] args) {
        Leetcode491 lc = new Leetcode491();
        int[] arr = {4,6,7,7};
        System.out.println(lc.findSubsequences(arr));
        res.clear();
        System.out.println(lc.findSubsequences2(arr));
        res.clear();
        System.out.println(lc.findSubsequences3(arr));
    }

    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        if(list.size() > 1) res.add(new ArrayList<>(list));
        if(index == nums.length) return;
        Set<Integer> set = new HashSet<>();
        for(int i=index; i<nums.length; i++) {
            if(set.contains(nums[i]))continue;
            if(list.isEmpty() || nums[i] >= list.get(list.size() -1)) {
                set.add(nums[i]);
                list.add(nums[i]);
                dfs(nums, i+1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences2(int[] nums) {
        dfs2(nums, 0,  new ArrayList<>());
        return res;
    }
    private void dfs2(int[] nums, int cur,  List<Integer> list) {
        if(cur == nums.length) {
            if(list.size() > 1) res.add(new ArrayList<>(list));
            return;
        }
        if(list.isEmpty() || nums[cur] >= list.get(list.size() - 1)) {
            list.add(nums[cur]);
            dfs2(nums, cur + 1, list);
            list.remove(list.size() - 1);
        }
        if(list.isEmpty() || nums[cur] != list.get(list.size() - 1)) {
            dfs2(nums, cur + 1, list);
        }
    }


    public List<List<Integer>> findSubsequences3(int[] nums) {
        dfs(nums, 0, Integer.MIN_VALUE, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, int cur, int pre, List<Integer> list) {
        if(cur == nums.length) {
            if(list.size() > 1) res.add(new ArrayList<>(list));
            return;
        }
        if(nums[cur] >= pre) {
            list.add(nums[cur]);
            dfs(nums, cur + 1, nums[cur], list);
            list.remove(list.size() - 1);
        }
        if(nums[cur] != pre) {
            dfs(nums, cur + 1, pre, list);
        }
    }
}
