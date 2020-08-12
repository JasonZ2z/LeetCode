package com.xinzhe.contest.biweeekly.biweekly28;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/6/13
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_biweekly_2803 {
    public static void main(String[] args) {
        int[] arr = {64,5,20,9,1,39};
        System.out.println(minSumOfLengths(arr, 69));
    }
    //超时
    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        long count = Arrays.stream(arr).filter(a -> a == target).count();
        if (count >= 2) return 2;



        pre[0] = 0;
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + arr[i];
        }

        int res = 0;
        int l = 0, r = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= n-i; ++j) {
                if(pre[j+i-1] - pre[j] == target) {
                    if(res == 0) {
                        l = j;
                        r = j+i;
                        res = 1;
                    }else {
                        if(l >= j+i || j >=  r) {
                            return r - l + i;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
