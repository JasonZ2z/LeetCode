package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/25 19:01
 * Title : 354. 俄罗斯套娃信封问题
 * Description : 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 *              当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *              请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *              说明:
 *              不允许旋转信封。
 * link : https://leetcode-cn.com/problems/russian-doll-envelopes
 * Level : Hard
 */

public class Leetcode354 {
    public static void main(String[] args) {
        int[][] n = {{1,1}};
        System.out.println(maxEnvelopes(n));
    }
    private static int maxEnvelopes(int[][] envelopes) {
        int m = envelopes.length;
        if(m == 0) return 0;

        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for(int j = i-1; j >= 0; --j) {
              if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                  dp[i] = Math.max(dp[j] +1, dp[i]);
              }
            }
            max = Math.max(max , dp[i]);
        }
        return max;
    }
}
