package com.xinzhe.contest.weekly.weekly193;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/14
 * Title :
 * Description :
 * link :
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
