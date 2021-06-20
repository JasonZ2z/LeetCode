package com.xinzhe.contest.biweeekly.s1.biweekly23;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/4/4 23:22
 * Title : 5363. 做菜顺序
 * Description : 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 *              一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
 *              请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 *              你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * link : https://leetcode-cn.com/problems/reducing-dishes
 * Level : Hard
 * Comment : 23双周赛04
 */
public class Leetcode_biweekly_2304 {
    public static void main(String[] args) {
        int[] a = {-1,-8,0,5,-9};
        System.out.println(maxSatisfaction(a));
    }
    public static int maxSatisfaction(int[] satisfaction) {
        if(satisfaction.length == 0) return 0;
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = satisfaction[i];
            for (int j = i-1; j >= 0; --j) {
                for (int k = j; k <= i; ++k) {
                    dp[j][i] += (k - j + 1) * satisfaction[k];
                }
                max = Math.max(max, dp[j][i]);
            }
        }
        return max;
    }
}
