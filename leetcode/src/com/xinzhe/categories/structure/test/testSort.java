package com.xinzhe.categories.structure.test;

import java.util.Arrays;

public class testSort {
    public static void main(String[] args) {
        int[] arr = {235,35345,346,45,654,645,54,
                4356,46,345647,5869,9,53,
                523,534,32,4,325,512,4324,
                432,543,5,3432,1,6,47,7,43545,546,54,
                765,64,2,35,4323,23,65,345,
                5,235,436,34,52,76};
        //bubbleSort(arr);
        //insertSort(arr);
        //selectSort(arr);
        //fastSort(arr,0, arr.length-1);
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
//        for (int i = 1; i <= arr.length; i++) {
//            if(i%15 != 0){
//                System.out.print(arr[i-1]);
//                System.out.print(", ");
//            } else{
//                System.out.println();
//            }
//        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag=true;
            for (int j = 0; j < arr.length -i - 1 ; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }

            }
        }
    }
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }
    public static void fastSort(int[] arr, int start, int end){
        if(start<end){
            int index = partition(arr, start, end);
            fastSort(arr, start, index-1);
            fastSort(arr, index+1, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left < right){
            while(arr[right] >= arr[start] && left < right){
                right--;
            }
            while(arr[left] <= arr[start] && left < right){
                left++;
            }
            if(left < right){
                swap(arr, left, right);
            }
        }
        swap(arr, start, left);
        return left;
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + ((end - start) >> 1);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr,start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] copy = new int[end - start +1];
        int left = start, right = mid+1;
        int index = 0;
        while(left <= mid && right <= end){
            copy[index++] = arr[right] > arr[left] ? arr[left++] : arr[right++];
        }
        while(left <= mid) {
            copy[index++] = arr[left++];
        }
        while(right <= end) {
            copy[index++] = arr[right++];
        }
        if(index > 0) System.arraycopy(copy,0,arr,start,index);
    }
}
