package com.xinzhe.contest.nowcoder.s107;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level :
 */
public class nowcoder_0601 {
    public static void main(String[] args) {
        nowcoder_0601 nc = new nowcoder_0601();
        int[] arr = {1,2};
        System.out.println(Arrays.toString(nc.sovle(arr, 1, 2)));
    }
    int[] test;
    public int[] sovle (int[] a, int n, int m) {
        // write code here
        int x = getTopK(a, n);
        int y = getTopK(a, m);
        int tmp = a[x];
        test = a.clone();
        Arrays.sort(test);
        a[x] = a[y];
        a[y] = tmp;
        return a;

    }

    private int getTopK(int[] arr, int n) {
        int a = test[test.length - n];
        for(int i=0; i<arr.length; i++){
            if(arr[i] == a) {
                return i;
            }
        }
        return 0;
    }
}
