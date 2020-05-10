package com.xinzhe.order.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/5/10
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_18802 {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        System.out.println(countTriplets(a));
    }
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;
        int count = 0;
        for (int i = 1; i < n; ++i) {
            List<Integer> alist = helperleft(arr, 0, i-1);
            List<Integer> blist = helperright(arr, i, n-1);
            System.out.println(alist + "    " + blist);
            for (int a : alist) {
                for (int b : blist) {
                    if(a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static List<Integer> helperleft(int[] arr, int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        int res = arr[r];
        list.add(res);
        for (int i = r-1; i >= l; --i) {
            res = res^arr[i];
            list.add(res);
        }
        //System.out.println("left " + list);
        return list;
    }

    private static List<Integer> helperright(int[] arr, int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();
        int res = arr[l];
        list.add(res);
        for (int i = l+1; i <= r; ++i) {
            res = res^arr[i];
            list.add(res);
        }
        //System.out.println("right " + list);
        return list;
    }


    public int countTriplets2(int[] arr) {
        int[] xor = new int[arr.length + 1];
        xor[0] = 0;
        for(int i = 1; i <= arr.length; i++) xor[i] = (xor[i - 1] ^ arr[i - 1]);
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j; k < arr.length; k++) {
                    if((xor[j] ^ xor[i]) == (xor[k + 1] ^ xor[j])) {
                        //System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
