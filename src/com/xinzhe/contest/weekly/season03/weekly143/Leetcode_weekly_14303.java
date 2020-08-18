package com.xinzhe.contest.weekly.season03.weekly143;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1105. 填充书架
 * Description : 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 *               按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 * link : https://leetcode-cn.com/problems/filling-bookcase-shelves
 * Level : Medium
 * tag : dp
 */
//todo need to review
public class Leetcode_weekly_14303 {
    public static void main(String[] args) {
        Leetcode_weekly_14303 lc = new Leetcode_weekly_14303();
    }
    public int minHeightShelves(int[][] books, int width) {
        int n = books.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; ++i) {
            int h = 0, w = 0;
            for(int j = i; j >= 0; --j) {
                w += books[j][0];
                h = Math.max(h, books[j][1]);
                if(w <= width) {
                    dp[i+1] = Math.min(dp[i+1], dp[j] + h);
                }else {
                    break;
                }
            }
        }
        return dp[n];
    }
}
