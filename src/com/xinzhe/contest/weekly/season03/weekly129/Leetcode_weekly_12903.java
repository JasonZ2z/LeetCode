package com.xinzhe.contest.weekly.season03.weekly129;

/**
 * @author Xin
 * @date 2020/9/18
 * Title : 1014. 最佳观光组合
 * Description :  给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *              一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。返回一对观光景点能取得的最高分。
 * link : https://leetcode-cn.com/problems/best-sightseeing-pair
 * Level : Medium
 */

//todo need to review
public class Leetcode_weekly_12903 {
    public static void main(String[] args) {
        Leetcode_weekly_12903 lc = new Leetcode_weekly_12903();
    }
    public int maxScoreSightseeingPair(int[] arr) {
        int n = arr.length;
        int ai = arr[0];
        int aj = -1001;
        for (int i = 1; i < n; ++i) {
            aj = Math.max(aj, ai + arr[i] - i);
            ai = Math.max(ai, i + arr[i]);
        }
        return aj;
    }
}
