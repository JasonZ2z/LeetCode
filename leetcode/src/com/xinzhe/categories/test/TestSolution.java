package com.xinzhe.categories.test;

import java.util.Arrays;

/**
 * @author xzheng
 * @since 1
 */
public class TestSolution {
    public static void main(String[] args) {
        int[] A = {4,5,6,0,0,0};
        int[] B = {1,2,3};
        merge(A,3,B,3);

    }
    public static void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(B, 0, A, m, n);
        for (int i = 0; i < m+n-1; i++) {
            boolean flag = true;
            for (int j = 0; j < m+n-i-1; j++) {
                if(A[j] > A[j+1]){
                    swap(A, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(A));
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
