package com.xinzhe.contest.weekly.season05.weekly225;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2021/01/24
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22503 {
    public static void main(String[] args) {
        Leetcode_weekly_22503 lc = new Leetcode_weekly_22503();
    }


    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if(i == 0) {
                    dp[i][j] = matrix[i][j] ^ dp[i][j-1];
                } else if(j == 0) {
                    dp[i][j] = matrix[i][j] ^ dp[i-1][j];
                } else {
                    dp[i][j] = matrix[i][j] ^ dp[i-1][j] ^ dp[i][j-1]^ dp[i-1][j-1];
                }
                queue.offer(dp[i][j]);
                if(queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
