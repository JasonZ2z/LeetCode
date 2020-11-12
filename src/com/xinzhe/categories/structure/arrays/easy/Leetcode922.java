package com.xinzhe.categories.structure.arrays.easy;

/**
 * @author Xin
 * @date 2020/11/12
 * Title : 922. 按奇偶排序数组 II
 * Description : 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。你可以返回任何满足上述条件的数组作为答案。
 * link : https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * Level : Easy
 */
public class Leetcode922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while(i < A.length) {
            if(A[i] % 2 == 1) {
                while(A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
            i += 2;
        }
        return A;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
