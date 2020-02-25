/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.xinzhe.categories.sort;
/**
 * @author xzheng
 * @date 2020-01-21 13:52
 */

import java.util.Arrays;

/**
 * TODO description
 *
 * @author xzheng
 * @since 1.0
 */
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
