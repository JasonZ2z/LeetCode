package com.xinzhe.contest.weekly.season05.weekly204;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/30
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20401 {
    public static void main(String[] args) {
        Leetcode_weekly_20401 lc = new Leetcode_weekly_20401();
        int[] arr = {1,2,3,1,2};
        System.out.println(lc.containsPattern(arr, 2, 2));
    }
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int count = 1;
            int j = i+m;
            while(j+m <= n) {
                if(Arrays.equals(arr, i, i+m, arr, j, j+m)) {
                   count++;
                   if(count >= k) return true;
                   j = j+m;
                }else {
                    break;
                }
            }
        }
        return false;
    }
}
