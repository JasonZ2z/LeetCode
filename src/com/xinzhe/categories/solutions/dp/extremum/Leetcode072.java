package com.xinzhe.categories.solutions.dp.extremum;

/**
 * @author Xin
 * @date 2020/4/6 19:04
 * Title : 72. 编辑距离
 * Description : 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *      你可以对一个单词进行如下三种操作：
 *          插入一个字符
 *          删除一个字符
 *          替换一个字符
 * link : https://leetcode-cn.com/problems/edit-distance
 * Level : Hard
 */
//todo need to review
public class Leetcode072 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; ++i) {
            for (int j = 0; j <= n2; ++j) {
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1]) +1;
            }
        }
        return dp[n1][n2];
    }
}
