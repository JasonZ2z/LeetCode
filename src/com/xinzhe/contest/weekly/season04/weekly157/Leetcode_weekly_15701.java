package com.xinzhe.contest.weekly.season04.weekly157;

/**
 * @Author Xin
 * @create 2020/7/16
 * Title : 1217. 玩筹码
 * Description : 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *          将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 *          将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 *      最开始的时候，同一位置上也可能放着两个或者更多的筹码。返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价
 * link : https://leetcode-cn.com/problems/play-with-chips
 * Level : Easy
 * Comment 157周赛01
 */

public class Leetcode_weekly_15701 {

    public static void main(String[] args) {
        Leetcode_weekly_15701 lc = new Leetcode_weekly_15701();
    }

    public int minCostToMoveChips(int[] chips) {
        int min = Integer.MAX_VALUE;
        for (int chip : chips) {
            min = Math.min(helper(chips, chip), min);
        }
        return min;
    }

    private int helper(int[] chips, int chip) {
        int count = 0;
        for (int i : chips) {
            if(Math.abs(i - chip) % 2 == 1) {
                count++;
            }
        }
        return count;
    }

}
