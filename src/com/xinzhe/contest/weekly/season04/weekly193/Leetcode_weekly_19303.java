package com.xinzhe.contest.weekly.season04.weekly193;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/14
 * Title : 1482. 制作 m 束花所需的最少天数
 * Description : 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *              花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中.请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * Level : Medium
 * Comment 193周赛03
 */
public class Leetcode_weekly_19303 {
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        System.out.println(minDays(arr, 3, 1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) return -1;

        int left = 1, right = Arrays.stream(bloomDay).boxed().max(Integer::compareTo).get();
        while (left < right) {
            int mid = left + (right - left) /2;
            int cur = helper(mid, bloomDay, k);
            if(cur < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int a = helper(left, bloomDay, k);
        if(a < m) return -1;
        return left;

    }

    private static int helper(int i, int[] bloomDay, int k) {
        int[] tmp = bloomDay.clone();
        for (int j = 0; j < bloomDay.length; j++) {
            if(bloomDay[j] <= i) {
                tmp[j] = 0;
            }
        }
        int count = 0;
        int s = 0;
        for (int value : tmp) {
            if (value == 0) {
                count++;
                if (count >= k) {
                    s++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return s;
    }
}
