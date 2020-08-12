package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/17 18:51
 * Title : 313. 超级丑数
 * Description : 编写一段程序来查找第 n 个超级丑数。超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 * link : https://leetcode-cn.com/problems/super-ugly-number/
 * Level : Medium
 */
public class Leetcode313 {
    public static void main(String[] args) {
        int[] p = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(12, p));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int m = primes.length;
        int[] indexs = new int[m];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if(dp[indexs[j]] * primes[j] < min) {
                    min = dp[indexs[j]] * primes[j];
                }
            }
            dp[i] = min;
            //Tips : 不能写在循环内部，否则primes 不+1；
            for (int j = 0; j < m; j++) {
                if(min == dp[indexs[j]] * primes[j]){
                    indexs[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
