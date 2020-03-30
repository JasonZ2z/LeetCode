package com.xinzhe.categories.structure.sort;

import java.util.Arrays;

public class SortDemo {
    private static int[] arr = {235,35345,346,45,654,645,54,
            4356,46,345647,5869,9,53,
            523,534,32,4,325,512,4324,
            432,543,5,3432,1,6,47,7,43545,546,54,
            765,64,2,35,4323,23,65,345,
            5,235,436,34,52,76};
    public static void main(String[] args) {
        System.out.println("------Bubble Sort------");
        //bubbleSort(arr);
        //selectSort(arr);
        fastSort(arr, 0, arr.length-1);
        //mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-1-i; j++) {
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
            for (int j = i; j > 0; j--) {
                if(arr[j-1] > arr[j]){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            if(arr[index] != arr[i]){
                swap(arr, i, index);
            }
        }
    }

    public static void fastSort(int[]arr, int start, int end){
        if(start < end){
            int index = partition(arr,start, end);
            fastSort(arr, start, index-1);
            fastSort(arr, index+1, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while(left < right){
            while(arr[right] >= arr[start] && right>left){
                right--;
            }
            while(arr[left] <= arr[start] && right > left){
                left++;
            }
            if(right > left){
                swap(arr, right, left);
            }
        }
        swap(arr, start, left);

        return left;
    }

    public static void mergeSort(int[]arr, int start, int end){
        if(start < end){
            int mid = start + ((end - start) >> 1);
            mergeSort(arr,start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] newArr = new int[end -start +1];
        int index = 0;
        int i=start, j=mid+1;
        while (i<= mid && j<= end){
            newArr[index++] = arr[j] > arr[i] ? arr[i++] : arr[j++];
        }
        while(i<=mid){
            newArr[index++] = arr[i++];
        }
        while(j<=end){
            newArr[index++] = arr[j++];
        }
        if(index > 0){
            for(int p=0,k=start; k<=end; k++, p++){
                arr[k] = newArr[p];
            }
        }
    }
}
