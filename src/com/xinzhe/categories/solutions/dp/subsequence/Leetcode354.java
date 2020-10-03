package com.xinzhe.categories.solutions.dp.subsequence;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/3/25 19:01
 * Title : 354. 俄罗斯套娃信封问题
 * Description : 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
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
        Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
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

    public int maxEnvelopes2(int[][] envelopes) {
        int m = envelopes.length;
        if(m == 0) return 0;
        //对于宽度 w 相同的数对，要对其高度 h 进行降序排序。因为两个宽度相同的信封不能相互包含的，逆序排序保证在 w 相同的数对中最多只选取一个。
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] -b[0]);
        int[] dp = new int[m];
        for (int i = 0; i < m; ++i) dp[i] = envelopes[i][1];
        int len = 0;
        for (int i = 0; i < m; ++i) {
            int j = Arrays.binarySearch(dp, 0, len, dp[i]);
            j = j < 0 ? -j -1 : j;
            dp[j] = dp[i];
            if(j == len) len++;
        }
        return len;
    }
}
