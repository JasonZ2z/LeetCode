package com.xinzhe.contest.weekly.season04.weekly192;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/7
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 192周赛02
 */
public class Leetcode_weekly_19202 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];
        int[] res = new int[k];
        int i = 0, left = 0, right = n - 1;
        while (i < k) {
            if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)) {
                res[i] = arr[left];
                left++;

            } else if (Math.abs(arr[right] - m) >= Math.abs(arr[left] - m)) {
                res[i] = arr[right];
                right--;
            }
            i++;
        }
        return res;
    }

}
