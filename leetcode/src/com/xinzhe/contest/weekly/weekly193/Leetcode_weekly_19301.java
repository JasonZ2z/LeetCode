package com.xinzhe.contest.weekly.weekly193;

/**
 * @Author Xin
 * @create 2020/6/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 193周赛01
 */
public class Leetcode_weekly_19301 {
    public int[] runningSum(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];

        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + arr[i];
        }
        return pre;
    }

}
