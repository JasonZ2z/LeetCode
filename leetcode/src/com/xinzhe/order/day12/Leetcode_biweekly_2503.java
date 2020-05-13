package com.xinzhe.order.day12;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/5/2
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_biweekly_2503 {
    public static void main(String[] args) {
        String s1 = "bxfowqvnrhuzwqohquamvszkvunb";
        String s2 = "xjegbjccjjxfnsiearbsgsofywtq";
        System.out.println(checkIfCanBreak(s1, s2));
    }
    public static boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; ++i) {
            arr1[i] = s1.charAt(i);
            arr2[i] = s2.charAt(i);
        }
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < n; ++i) {
            if(arr1[i] < arr2[i]) {
                flag1 = false;
                break;
            }
        }

        for (int i = 0; i < n; ++i) {
            if(arr1[i] > arr2[i]) {
                flag2 =false;
                break;
            }
        }

        return flag1 | flag2;

    }
}
