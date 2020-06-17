package com.xinzhe.contest.weekly.season04.weekly168;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Author Xin
 * @create 2020/6/01
 * Title : 1296. 划分数组为连续数字的集合
 * Description : 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。如果可以，请返回 True；否则，返回 False。
 * link : https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
 * Level : Medium
 * Comment 168周赛02
 */

public class Leetcode_weekly_16802 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            int start = map.firstKey();
            for (int i = start; i < k + start; ++i) {
                if (!map.containsKey(i)) return false;
                int tmp = map.get(i);
                if (tmp == 1) map.remove(i);
                else map.put(i, tmp - 1);
            }
        }
        return true;
    }

}
