package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/5 19:55
 * Title : 216. 组合总和 III
 * Description : 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *      所有数字都是正整数。
 *      解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * link : https://leetcode-cn.com/problems/combination-sum-iii/
 * Level : Medium
 */
public class Leetcode216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        traceback(n, k, new ArrayList<>(),1);
        return result;
    }

    private static void traceback(int sum, int k, ArrayList<Integer> track, int start) {
        int tmp = track.stream().mapToInt(Integer::valueOf).sum();
        if(track.size() == k && tmp == sum){
            result.add(new ArrayList<>(track));
            return;
        }

        if(tmp > sum || track.size() > k) return;

        for (int i = start; i <= 9; i++) {

                track.add(i);
                traceback(sum, k, track, i+1);
                track.remove(track.size()-1);

        }


    }
}
