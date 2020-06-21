package com.xinzhe.contest.weekly.season04.weekly194;

/**
 * @Author Xin
 * @create 2020/6/21
 * Title :
 * Description :
 * link :
 * Level : Easy
 * Comment 194周赛01
 */
public class Leetcode_weekly_19401 {
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start + 2 * i;
        }
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
}
