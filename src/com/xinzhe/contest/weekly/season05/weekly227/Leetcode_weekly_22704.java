package com.xinzhe.contest.weekly.season05.weekly227;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * @author Xin
 * @date 2021/02/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22704 {
    public static void main(String[] args) {
        Leetcode_weekly_22704 lc = new Leetcode_weekly_22704();
    }

    public int minAbsDifference(int[] nums, int goal) {
        TreeSet<Integer> set1 = new TreeSet<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        minAbsDifference(0, nums.length / 2, 0, nums, set1);
        minAbsDifference(nums.length / 2, nums.length, 0, nums, set2);
        int min = Integer.MAX_VALUE;
        for (int i : set2) {
            Integer j = set1.floor(goal - i), k = set1.ceiling(goal - i);
            if (j != null) {
                min = Math.min(min, Math.abs(i + j - goal));
            }
            if (k != null) {
                min = Math.min(min, Math.abs(i + k - goal));
            }
            if (min == 0) {
                return 0;
            }
        }
        return min;
    }

    private void minAbsDifference(int i, int j, int sum, int[] nums, Collection<Integer> set) {
        if (i == j) {
            set.add(sum);
        } else {
            minAbsDifference(i + 1, j, sum, nums, set);
            minAbsDifference(i + 1, j, sum + nums[i], nums, set);
        }
    }
}
