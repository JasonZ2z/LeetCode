package com.xinzhe.categories.dp.subsequence;

/**
 * @Author Xin
 * @create 2020/3/18 18:01
 * Title : 718. 最长重复子数组
 * Description : 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *      输入:
 *          A: [1,2,3,2,1]
 *          B: [3,2,1,4,7]
 *      输出: 3 长度最长的公共子数组是 [3, 2, 1]。
 * link : https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * Level : Medium
 */

public class Leetcode718 {
    public static void main(String[] args) {
        int[] a = {1,2,1,4,7};
        int[] b = {3,2,1,4,7,5,7,1,4,7,2,3,4,5,6,7,1,2,1,4};
        System.out.println(findLength(a, b));
    }
    public static int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];

        //init
        int max = 0;
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                if(A[i-1] == B[j-1] ){
                    dp[i][j] = dp[i-1][j-1] +1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
