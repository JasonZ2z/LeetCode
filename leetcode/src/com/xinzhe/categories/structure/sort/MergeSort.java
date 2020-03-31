package com.xinzhe.categories.structure.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,1,4,5,6,88,99,44,23446546,21342};
        mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void mergeSort(int[] array) {
        if(array == null || array.length == 0) return;
        mSort(array, 0, array.length-1);

    }

    private static void mSort(int[] array, int min, int max) {
        if(min == max) return;
        int mid = min + ((max - min) >> 1);
        mSort(array, min, mid);
        mSort(array, mid+1, max);
        merge(array, min, mid, max);
    }

    private static void merge(int[] array, int min, int mid, int max) {
        int[] tmp = new int[max-min +1];
        int i = min, j = mid +1;
        int index = 0;
        while(i<=mid && j<=max){
            tmp[index++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while(i <= mid){
            tmp[index++] = array[i++];
        }
        while(j <= max){
            tmp[index++] = array[j++];
        }
        if (index >= 0) System.arraycopy(tmp, 0, array, min, index);
    }
}
