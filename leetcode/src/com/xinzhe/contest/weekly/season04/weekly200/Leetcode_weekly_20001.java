package com.xinzhe.contest.weekly.season04.weekly200;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20001 {
    public static void main(String[] args) {
        Leetcode_weekly_20001 lc = new Leetcode_weekly_20001();
    }
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i+1; j < n - 1; ++j) {
                if(Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j+1; k < n; ++k) {
                        if(Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }
}
