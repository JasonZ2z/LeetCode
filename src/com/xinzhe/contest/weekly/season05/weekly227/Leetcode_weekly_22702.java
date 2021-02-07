package com.xinzhe.contest.weekly.season05.weekly227;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/02/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22702 {
    public static void main(String[] args) {
        Leetcode_weekly_22702 lc = new Leetcode_weekly_22702();
    }

    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        if(arr[2] >= arr[0] + arr[1]) return arr[0] + arr[1];
        return (a + b + c)/2;
    }
}
