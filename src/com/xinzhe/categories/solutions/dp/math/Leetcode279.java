package com.xinzhe.categories.solutions.dp.math;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xin
 * @date 2020/3/17 18:11
 * Title : 279. 完全平方数
 * Description : 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * link : https://leetcode-cn.com/problems/perfect-squares/
 * Level : Medium
 */

public class Leetcode279 {

    //dp
    //i-j*j
    public int numSquares2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i<=n; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; ++j){
                dp[i] = Math.min(dp[i - j*j] +1, dp[i]);
            }
        }
        return dp[n];
    }

    //bfs
    public int numSquares(int n) {
        int ans = 0;
        boolean[] used = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()){
            ans++;
            int size =  queue.size();
            for (int i = 0; i < size; ++i) {
                int cur = queue.poll();
                for (int j = 1; j*j<= cur; ++j) {
                    if(cur - j * j == 0) return ans;
                    if(!used[cur - j * j]) {
                        used[cur - j* j] = true;
                        queue.add(cur - j* j);
                    }
                }
            }
        }
        return ans;
    }
    //四平方和定理
    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    public int numSquares1(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }

}
