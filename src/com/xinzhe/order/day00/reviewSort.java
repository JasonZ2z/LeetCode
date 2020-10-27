package com.xinzhe.order.day00;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xzheng
 * @date 2020/10/26
 */

public class reviewSort {
    public static void main(String[] args) {
       int[] arr = generateArrays(10);
       System.out.println(Arrays.toString(arr));
       int n = arr.length;
       int[] arr4 = new int[n], arr3 = new int[n], arr2 = new int[n], arr1 = new int[n];
       System.arraycopy(arr, 0, arr1, 0, n);
       System.arraycopy(arr, 0, arr2, 0, n);
       System.arraycopy(arr, 0, arr3, 0, n);
       System.arraycopy(arr, 0, arr4, 0, n);
        reviewSort rs = new reviewSort();
        rs.bubbleSort(arr);
        rs.selectSort(arr1);
        rs.insertSort(arr2);
        rs.fastSort(arr3, 0, n-1);
        rs.quickSort(arr4, 0, n-1);
        System.out.println(rs.compare(arr, arr1));
        System.out.println(rs.compare(arr1, arr2));
        System.out.println(rs.compare(arr2, arr3));
        System.out.println(rs.compare(arr3, arr4));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

    }

    private static int[] generateArrays(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            arr[i] = random.nextInt(n * 10 + 1);
        }
        return arr;
    }

    public void swap(int[] arr, int i , int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; ++i) {
            boolean flag = true;            // optimize
            for (int j = 0; j < n-i-1; ++j) {
                if(arr[j] > arr[j+1]) {
                    flag = false;
                    swap(arr, j, j+1);
                }
            }
            if(flag) return;
        }
    }

    public void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int cur = arr[i];
            int j = i;
            for(; j > 0 && cur < arr[j-1]; j--) {
                arr[j] = arr[j-1];      // 插入排序，不需要每次都交换，每个元素后移，最后合适的位置插入
            }
            arr[j] = cur;
        }
    }

    public void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; ++i) {
            int min = i;                // 选择排序， 选择最小的
            for (int j = i; j < n; ++j) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                swap(arr, min, i);
            }
        }
    }

    private void fastSort(int[] arr, int left, int right) {
        if(right > left) {
            Random random = new Random();  // optimize 1
            int ran = random.nextInt(right - left + 1) + left;
            swap(arr, left, ran);
            int pivot = arr[left];
            int l = left, r = right;    // optimize 2 , l = left;  二路归并
            while (l < r) {
                while (l < r && arr[r] > pivot)  r--; //   这里必须先右后左；
                while (l < r && arr[l] <= pivot)  l++;
                if(l < r) swap(arr, l ,r);
            }
            swap(arr, left, l);
            fastSort(arr, left, l-1);
            fastSort(arr, l+1, right);
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;
        int pivot = arr[left];
        int l = left - 1, r = right + 1;
        while(l < r) {
            do l++; while (arr[l] < pivot);
            do r--; while (arr[r] > pivot);
            if(l < r) swap(arr, l ,r);
        }
        quickSort(arr, left, r);
        quickSort(arr, r+1, right);
    }

    public void mergeSort(int[] arr) {

    }

    public boolean compare(int[] arr1, int[] arr2) {
        if(arr1.length !=  arr2.length) return false;
        for (int i = 0; i < arr1.length; ++i) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
