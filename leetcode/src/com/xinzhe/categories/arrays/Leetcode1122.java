package com.xinzhe.categories.arrays;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/3/27 18:55
 * Title : 1122. 数组的相对排序
 * Description : 给你两个数组，arr1 和 arr2，
 *              arr2 中的元素各不相同
 *              arr2 中的每个元素都出现在 arr1 中
 *              对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * link : https://leetcode-cn.com/problems/relative-sort-array
 * Level : Easy
 */

public class Leetcode1122 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        if(n == 0) return new int[0];
        if(arr2 == null) return arr1;

        int[] dp = new int[1000];
        for (int i : arr1) {
            dp[i] += 1;
        }
        int i=0;
        for (int j : arr2) {
            int count = dp[j];
            while (count-- > 0){
                arr1[i++] = j;
            }
            dp[j] = 0;
        }
        for (int k = 0; k < 1000; ++k) {
            if(dp[k] > 0){
                int count = dp[k];
                while (count-- > 0){
                    arr1[i++] = k;
                }
            }
        }

        return arr1;
    }
}
