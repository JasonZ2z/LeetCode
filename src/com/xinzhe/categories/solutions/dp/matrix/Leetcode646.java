package com.xinzhe.categories.solutions.dp.matrix;


import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/26 19:55
 * Title : 646. 最长数对链
 * Description : 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *              现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *              给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造
 * link : https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 * Level : Medium
 */

public class Leetcode646 {
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        if(m == 0) return 0;

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[m];
        Arrays.fill(dp ,1);
        int res = 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < i; ++j) {
                if(pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
