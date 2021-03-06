package com.xinzhe.categories.solutions.greedy.hard;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/12/08
 * Title : 135. 分发糖果
 * Description : 老师想给孩子们分发糖果，有 N个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *              每个孩子至少分配到 1 个糖果。相邻的孩子中，评分高的孩子必须获得更多的糖果。那么这样下来，老师至少需要准备多少颗糖果呢？
 * link : https://leetcode-cn.com/problems/candy
 * Level : Hard
 */
//todo need to review
public class Leetcode135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            if(ratings[i] > ratings[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        for(int i = n-2; i >= 0; --i) {
            if(ratings[i] > ratings[i+1] && dp[i] <= dp[i+1]) {
                dp[i] = dp[i+1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
