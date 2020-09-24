package com.xinzhe.categories.solutions.dp.interval;

/**
 * @author Xin
 * @date 2020/8/15
 * Title : 546. 移除盒子
 * Description : 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 *          你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 *          当你将所有盒子都去掉之后，求你能获得的最大积分和。
 * link : https://leetcode-cn.com/problems/remove-boxes
 * Level : Hard
 */

//todo too hard to solve
public class Leetcode546 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,2,3,4,3,1};
        Leetcode546 lc = new Leetcode546();
        System.out.println(lc.removeBoxes(arr));
    }
    
    int[][][] dp = new int[105][105][105];
    public int removeBoxes(int[] a) {
        int n = a.length;
        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = Math.max(dp[i][j][k], (j - 1 < i ? 0: dp[i][j - 1][0]) + (k + 1) * (k + 1));
                    for(int t = i; t <= j - 1; t++){
                        if(a[t] == a[j]){
                            dp[i][j][k] = Math.max(dp[i][j][k], (t + 1 > j - 1 ? 0: dp[t + 1][j - 1][0]) +
                                    dp[i][t][k + 1]);
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][0];
    }
}
