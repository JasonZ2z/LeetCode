package com.xinzhe.categories.solutions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/5 18:55
 * Title : 39. 组合总和
 * Description : 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *              candidates 中的数字可以无限制重复被选取。
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * link : https://leetcode-cn.com/problems/combination-sum/
 * Level : Medium
 */
public class Leetcode039 {

    public static void main(String[] args) {
        int[] c = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(c, 8));
    }
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
        traceback(candidates, 0, new ArrayList<>(), target);
        return result;

    }

    private static void traceback(int[] candidates, int start, List<Integer> list, int target) {
        int sum = list.stream().mapToInt(Integer::valueOf).sum();
        if( sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            traceback(candidates, i, list, target);
            list.remove(list.size()-1);

        }
    }
}
