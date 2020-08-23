package com.xinzhe.categories.structure.arrays.hard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/6/6
 * Title : 128. 最长连续序列
 * Description : 给定一个未排序的整数数组，找出最长连续序列的长度。要求算法的时间复杂度为 O(n)。
 * link : https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * Level : Hard
 */
//todo need to review
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int len = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    len++;
                    cur++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
