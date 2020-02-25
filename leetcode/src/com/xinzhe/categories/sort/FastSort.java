package com.xinzhe.categories.sort;

import java.util.Arrays;

public class FastSort {
    public static void main(String[] args) {
        int[] arr ={1,1,1,2,3,4,5,0,7,8,92,3,4,7,5,9,66,0,74,46};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end){
        if(start < end) {
            int index = partition(arr, start, end);
            sort(arr, start, index-1);
            sort(arr, index+1, end);
        }
        
    }

    private static int partition(int[] arr, int start, int end) {
        int anchor = arr[start];
        int left = start;
        int right = end;
        while(left < right){
            while(arr[right] >= anchor && right > left){
                right--;
            }
            while(arr[left] <= anchor && left < right){
                left++;
            }
            if(left < right){
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
            }
        }
        arr[start] = arr[left];
        arr[left] =  anchor;
        return left;
    }
}
