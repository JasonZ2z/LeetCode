package com.xinzhe.categories.solutions.backtrack.medium;

import java.util.ArrayList;

/**
 * @Author Xin
 * @create 2020/3/5 19:55
 * Title : 377. 组合总和 Ⅳ
 * Description : 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 示例:
 *      nums = [1, 2, 3]
 *      target = 4
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。因此输出为 7。
 * link : https://leetcode-cn.com/problems/combination-sum-iv
 * Level : Medium
 */
public class Leetcode377 {
    public static void main(String[] args) {
        int[] c = {4,2,1};
        System.out.println(combinationSum4(c, 32));
    }
    //常规回溯超时，需用递归
    static int count = 0;
    public static int combinationSum4(int[] nums, int target) {
        traceback(nums, target, new ArrayList<>());
        return count;
    }

    private static void traceback(int[] nums, int target, ArrayList<Integer> track) {
        int sum = track.stream().mapToInt(Integer::valueOf).sum();
        if(sum == target){
            count++;
            return;
        }
        if(sum > target) return;
        for (int num : nums) {
            track.add(num);
            traceback(nums, target, track);
            track.remove(track.size() - 1);
        }
    }
}
