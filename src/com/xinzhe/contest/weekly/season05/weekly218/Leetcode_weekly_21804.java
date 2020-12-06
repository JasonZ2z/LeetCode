package com.xinzhe.contest.weekly.season05.weekly218;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2020/12/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
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
