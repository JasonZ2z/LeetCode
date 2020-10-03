package com.xinzhe.categories.solutions.dp.extremum;

/**
 * @author Xin
 * @date 2020/4/10 21:37
 * Title : 1014. 最佳观光组合
 * Description : 创给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *              一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。返回一对观光景点能取得的最高分。
 * link : https://leetcode-cn.com/problems/best-sightseeing-pair
 * Level : Medium
 */

public class Leetcode1014 {
    public int maxScoreSightseeingPair(int[] a) {
        int n = a.length;
        if(n == 2) return a[0] + a[1] -1;
        int ai = a[0];
        int aj = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i) {
            aj = Math.max(aj, ai + a[i] -i);
            ai = Math.max(ai, a[i] + i);
        }
        return aj;
    }
}
