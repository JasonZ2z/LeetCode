package com.xinzhe.categories.structure.arrays.easy;

/**
 * @author Xin
 * @date 2020/11/12
 * Title : 905. 按奇偶排序数组
 * Description : 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。你可以返回满足此条件的任何数组作为答案。
 * link : https://leetcode-cn.com/problems/sort-array-by-parity
 * Level : Easy
 */
public class Leetcode905 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length-1;
        while(i < j) {
            if(A[i] % 2 == 1) {
                swap(A, i, j);
                j--;
            }else {
                i++;
            }
        }
        return A;
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
