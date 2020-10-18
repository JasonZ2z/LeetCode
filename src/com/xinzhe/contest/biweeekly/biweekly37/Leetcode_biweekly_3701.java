package com.xinzhe.contest.biweeekly.biweekly37;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/17
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_3701 {
    public static void main(String[] args) {

    }
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int x = (int)(n * 0.05);
        double c  = (n * 0.9);
        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < x; ++i) {
            sum -= arr[i] + arr[n-i-1];
        }
        return sum / c;
    }
}
