/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.xinzhe.sort;
/**
 * @author xzheng
 * @date 2020-01-22 13:52
 */

import java.util.Arrays;

public class Test {

    private static int[] arr ={1,1,1,2,3,4,5,0,7,8,92,3,4,7,5,9,66,0,74,46};
    public static void main(String[] args) {
        System.out.println("-----Bubble Sort-----:");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----Select Sort-----:");
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----Insert Sort-----:");
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----Fast Sort-----:");
        fastSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));


    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]=tmp;
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = false;
                }
            }
            if(flag){
                break;
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
            if(min != i){
                swap(arr, i, min);
            }
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }

        }
    }

    public static void fastSort(int[] arr, int start, int end){
        if(start < end){
            int part = fastSortPartition(arr, start ,end);
            fastSort(arr, start, part-1);
            fastSort(arr, part+1, end);
        }
    }

    public static int fastSortPartition(int[] arr, int start, int end){
        int left = start;
        int right = end;
        int anchor = arr[start];
        while (left < right){
            while(arr[right] >= anchor && left < right){
                right--;
            }
            while(arr[left] <= anchor && left < right){
                left++;
            }
            if(left < right){
                swap(arr, left, right);
            }
        }
        arr[start] = arr[left];
        arr[left] = anchor;
        return left;
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = start + (end - start) >> 1;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {

    }
}
