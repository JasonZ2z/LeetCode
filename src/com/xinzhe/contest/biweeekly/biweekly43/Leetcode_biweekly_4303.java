package com.xinzhe.contest.biweeekly.biweekly43;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/01/09
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4303 {
    public static void main(String[] args) {
        Leetcode_biweekly_4303 lc = new Leetcode_biweekly_4303();
        int[] arr = {2, 4, 9, 3};
//        System.out.println(Arrays.toString(lc.constructDistancedSequence(1)));
//        System.out.println(Arrays.toString(lc.constructDistancedSequence(2)));
//        System.out.println(Arrays.toString(lc.constructDistancedSequence(3)));
        System.out.println(Arrays.toString(lc.constructDistancedSequence(5)));
        //System.out.println(Arrays.toString(lc.constructDistancedSequence(11)));
    }
    int[] res;
    public int[] constructDistancedSequence(int n) {
        if(n == 1) return new int[]{1};
        int len = 1 + (n - 1) * 2;
        this.res = new int[len];
        helper(n, new int[len]);
        return res;
    }

    private boolean helper(int n, int[] arr) {
        if(n == 1) {
            int index = 0;
            for (int i = 0; i < arr.length; ++i) {
                if(arr[i] == 0) {
                    index = i;
                    arr[index] = 1;
                }
            }
            for (int i = 0; i < arr.length; ++i) {
                if(arr[i] < res[i]) {
                    arr[index] = 0;
                    return false;
                } else if(arr[i] > res[i]){
                    System.arraycopy(arr, 0, res, 0, arr.length);
                    return true;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0 && i + n < arr.length && arr[i + n] == 0) {
                arr[i] = n;
                arr[i + n] = n;
                if(helper(n-1, arr)) {
                    return true;
                } else {
                    arr[i] = 0;
                    arr[i + n] = 0;
                }

            }
        }
        return false;
    }
}