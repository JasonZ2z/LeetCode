package com.xinzhe.categories.solutions.dp.math;

/**
 * @author Xin
 * @date 2020/3/16
 * Title : 338. 比特位计数
 * Description : 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * link : https://leetcode-cn.com/problems/counting-bits/
 * Level : Medium
 */
//todo need to review
public class Leetcode338 {
    public static void main(String[] args) {
        int i = 1 & 3;
        int i1 = 3 >> 1;
        System.out.println(i);
        System.out.println(i1);
    }
    //i >> 1会把最低位去掉，因此i >> 1 也是比i小的
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for(int i=0; i<=num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
    //i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
