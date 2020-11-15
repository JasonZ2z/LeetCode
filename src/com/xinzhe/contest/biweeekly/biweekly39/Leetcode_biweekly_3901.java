package com.xinzhe.contest.biweeekly.biweekly39;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3901 {
    public static void main(String[] args) {
        Leetcode_biweekly_3901 lc = new Leetcode_biweekly_3901();
        int[] arr = {2,4,9,3};
        System.out.println(Arrays.toString(lc.decrypt(arr, -2)));
    }
    public int[] decrypt(int[] code, int k) {
        if(k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int n = code.length;
        int[] tmp = new int[n * 2];
        System.arraycopy(code, 0, tmp, 0, n);
        System.arraycopy(code, 0, tmp, n, n);
        int[] res = new int[n];
        if(k > 0) {
            for(int i=0; i<n; i++) {
                for(int j=1; j<=k; j++) {
                    res[i] += tmp[i+j];
                }
            }
            return res;
        } else {
            k *= -1;
            for(int i=n; i<2 * n; i++) {
                for(int j=1; j<=k; j++) {
                    res[i-n] += tmp[i-j];
                }
            }
            return res;
        }
    }
}
