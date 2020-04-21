package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/3/5 18:55
 * Title : 40. 组合总和 II
 * Description : 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * link : https://leetcode-cn.com/problems/combination-sum-ii
 * Level : Medium
 */
public class Leetcode040 {

    public static void main(String[] args) {
        int[] c = {2,5,2,1,2};
        System.out.println(combinationSum2(c, 5));
    }
    static Set<List<Integer>> result = new HashSet<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traceback(candidates,target, new ArrayList<>(), 0);
        return new ArrayList<>(result);
    }

    private static void traceback(int[] candidates, int target, ArrayList<Integer> track, int start) {

        int sum = track.stream().mapToInt(Integer::valueOf).sum();
        if(sum == target){
            result.add(new ArrayList<>(track));
            return;
        }
        if(sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            track.add(candidate);
            traceback(candidates, target, track, i+1);
            track.remove(track.size()-1);
        }
    }
}
