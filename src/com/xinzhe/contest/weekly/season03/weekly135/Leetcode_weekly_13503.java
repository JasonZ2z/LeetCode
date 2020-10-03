package com.xinzhe.contest.weekly.season03.weekly135;

/**
 * @author Xin
 * @date 2020/8/27
 * Title : 1039. 多边形三角剖分的最低得分
 * Description : 给定 N，想象一个凸 N 边多边形，其顶点按顺时针顺序依次标记为 A[0], A[i], ..., A[N-1]。
 *              假设您将多边形剖分为 N-2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 N-2 个三角形的值之和。
 *              返回多边形进行三角剖分后可以得到的最低分。
 * link : https://leetcode-cn.com/problems/minimum-score-triangulation-of-polygon
 * Level : Easy
 */
//todo need to review
public class Leetcode_weekly_13503 {
    public static void main(String[] args) {

    }
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + A[l] * A[k] * A[r]);
                }
            }
        }
        return dp[0][n - 1];
    }

}
