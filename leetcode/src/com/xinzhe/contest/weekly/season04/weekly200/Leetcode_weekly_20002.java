package com.xinzhe.contest.weekly.season04.weekly200;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20002 {
    public static void main(String[] args) {
        Leetcode_weekly_20002 lc = new Leetcode_weekly_20002();
        int arr[] ={963,541,112,470,285,93,24,953,536,363,575,522,390,9,873,940,921,198,75};
        System.out.println(lc.getWinner(arr, 6));
    }
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        if(k >= n) return Arrays.stream(arr).max().getAsInt();
        if(k == 1) return Math.max(arr[0], arr[1]);

        int[] copy = new int[n* 2];
        System.arraycopy(arr, 0,copy,0, n);
        System.arraycopy(arr, 0,copy,n, n);
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = i+1; j<2*n; j++) {
                if(copy[j] < copy[i]) {
                    count++;
                } else {
                    break;
                }
            }
            if(count >= k-1) {
                if(i == 0) {
                    if(count > k) {
                        return arr[i];
                    }
                } else {
                    return arr[i];
                }

            }

        }
        return 0;
    }
}
