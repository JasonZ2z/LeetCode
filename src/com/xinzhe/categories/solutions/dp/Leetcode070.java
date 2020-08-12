package com.xinzhe.categories.solutions.dp;

/**
 * @Author Xin
 * @create 2020/3/9 18:21
 * Title : 70. 爬楼梯
 * Description : 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *              每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *              注意：给定 n 是一个正整数。
 * link : https://leetcode-cn.com/problems/climbing-stairs/
 * Level : Medium
 */
public class Leetcode070 {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
