package com.xinzhe.categories.structure.sort;

import java.util.Arrays;

/**
 * @author xzheng
 * @since 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr ={1,1,1,2,3,4,5,0,7,8,92,3,4,7,5,9,66,0,74,46};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int len = arr.length;
        int beginIndex = (len-1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            adjustHeap(arr,i,len);
        }
        for (int i = len-1; i > 0 ; i--) {
            swap(arr,0, i);
            adjustHeap(arr,0, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        int tmp = arr[i];
        for(int k=i*2+1; k<len; k=k*2+1){
            if(k+1<len && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > tmp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = tmp;
    }
}
