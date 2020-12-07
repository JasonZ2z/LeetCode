package com.xinzhe.contest.weekly.season05.weekly218;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2020/12/06
 * Title : 1681. 最小不兼容性
 * Description : 给你一个整数数组nums 和一个整数k。你需要将这个数组划分到k个相同大小的子集中，使得同一个子集里面没有两个相同的元素。一个子集的 不兼容性是该子集里面最大值和最小值的差。
 *              请你返回将数组分成 k个子集后，各子集 不兼容性 的 和的 最小值，如果无法分成分成 k个子集，返回 -1。子集的定义是数组中一些数字的集合，对数字顺序没有要求
 * link : https://leetcode-cn.com/problems/minimum-incompatibility
 * Level : Hard
 */
//todo need to review
    // 状压DP
public class Leetcode_weekly_21804 {
    public static void main(String[] args) {
        Leetcode_weekly_21804 lc = new Leetcode_weekly_21804();
        int[] arr = {3,5};
    }
    private int min;
    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        min = Integer.MAX_VALUE;
        TreeSet<Integer>[] sets = new TreeSet[k];
        for (int i = 0; i < k; i++) {
            sets[i] = new TreeSet<>();
        }
        minimumIncompatibility(0, nums, sets);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void minimumIncompatibility(int index, int[] nums, TreeSet<Integer>[] sets) {
        if (index == nums.length) {
            int sum = 0;
            for (TreeSet<Integer> set : sets) {
                sum += set.last() - set.first();
            }
            min = Math.min(min, sum);
        } else {
            for (TreeSet<Integer> set : sets) {
                if (set.isEmpty()) {
                    set.add(nums[index]);
                    minimumIncompatibility(index + 1, nums, sets);
                    set.remove(nums[index]);
                    break;
                } else if (set.size() < nums.length / sets.length && !set.contains(nums[index])) {
                    set.add(nums[index]);
                    minimumIncompatibility(index + 1, nums, sets);
                    set.remove(nums[index]);
                }
            }
        }
    }

}
