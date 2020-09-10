package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Xin
 * @date 2020/3/5 18:55
 * Title : 40. 组合总和 II
 * Description : 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的每个数字在每个组合中只能使用一次。
 * link : https://leetcode-cn.com/problems/combination-sum-ii
 * Level : Medium
 */
public class Leetcode040 {
    public static void main(String[] args) {
        Leetcode040 lc = new Leetcode040();
        int[] arr = {10,1,2,7,6,1,5};
        System.out.println(lc.combinationSum2(arr, 8));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> list) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] > target) continue;
            if(i > index && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i+1, list);
            list.remove(list.size()-1);
        }
    }
}
