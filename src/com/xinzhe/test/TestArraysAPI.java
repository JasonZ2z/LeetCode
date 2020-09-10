package com.xinzhe.test;

import java.util.Arrays;

public class TestArraysAPI {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9};
        int n = arr.length;
        System.out.println(Arrays.binarySearch(arr, 0, n, 2));
        System.out.println(Arrays.binarySearch(arr, 0, n, 0));
        System.out.println(Arrays.binarySearch(arr, 0, n, 6));
        System.out.println(Arrays.binarySearch(arr, 0, n, 10));


        int[][] arr2 = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(Arrays.binarySearch(arr2,0, arr2.length, arr2[1], (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
    }
}
