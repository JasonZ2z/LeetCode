package com.xinzhe.contest.weekly.season03.weekly137;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1049. 最后一块石头的重量 II
 * Description : 有一堆石头，每块石头的重量都是正整数。
 *              每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *              如果 x == y，那么两块石头都会被完全粉碎；
 *              如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *              最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * link : https://leetcode-cn.com/problems/last-stone-weight-ii
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_13704 {
    public static void main(String[] args) {
        Leetcode_weekly_13704 lc = new Leetcode_weekly_13704();
    }

    public int lastStoneWeightII(int[] stones) {
        if(stones.length == 0) return 0;
        int all = Arrays.stream(stones).sum();
        int sum = all /2;
        int[] dp = new int[sum+1];
        for (int stone : stones) {
            for (int i = sum; i >= stone ; i--) {
                dp[i] = Math.max(dp[i], dp[i-stone] + stone);
            }
        }
        return all - 2* dp[sum];
    }
}
