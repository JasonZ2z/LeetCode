package com.xinzhe.top100.easy;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/2/28 10:10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode001 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0 ) return new int[0];
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr,0,res,0, k);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 2)));
    }
}
