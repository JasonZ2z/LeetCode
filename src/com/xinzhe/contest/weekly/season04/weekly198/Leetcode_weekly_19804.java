package com.xinzhe.contest.weekly.season04.weekly198;

import java.util.ArrayList;

/**
 * @Author Xin
 * @create 2020/7/19
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_19804 {
    public static void main(String[] args) {
        Leetcode_weekly_19804 lc = new Leetcode_weekly_19804();
    }

    public int closestToTarget(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || i != list.get(list.size() - 1)) {
                list.add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int X = list.get(i);
            for (int j = i; j < list.size(); j++) {
                X &= list.get(j);
                ans = Math.min(ans, Math.abs(target - X));
                if (X <= target)
                    break;
            }
        }
        return ans;
    }
}
