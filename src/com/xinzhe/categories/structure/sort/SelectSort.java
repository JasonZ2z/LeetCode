package com.xinzhe.categories.structure.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,7,5,9,66,0,74,46};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
