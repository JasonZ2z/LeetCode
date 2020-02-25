package com.xinzhe.categories.sort;
/**
 * @author xzheng
 * @date 2020-01-20 17:42
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,7,5,9,66,0,74,46};
        sort3(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void sort1(int[] arr){
        if(arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void sort2(int[] arr){
        if(arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void sort3(int[] arr){
        if(arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length -i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
