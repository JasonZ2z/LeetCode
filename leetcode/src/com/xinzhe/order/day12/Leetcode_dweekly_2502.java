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
public class Leetcode_dweekly_2502 {
    public static void main(String[] args) {
       // System.out.println(maxDiff(555));
        System.out.println(maxDiff(1101057));
        //System.out.println(maxDiff(1000));
        //System.out.println(maxDiff(9288));
    }
    public static int maxDiff(int num) {
        int copy = num;
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        for(int i = n-1; i >= 0; --i) {
            arr[i] = copy % 10;
            copy /= 10;
        }

        int[] min = new int[n];
        int[] max = new int[n];
        if(arr[0] == 1) {
            int tmp = 0;
            min[0] = 1;
            for (int i = 1; i < n; ++i) {
                if(arr[i] != 1 && arr[i] != 0) {
                    tmp = arr[i];
                    break;
                }
            }
            for (int i = 1; i < n; ++i) {
                if(arr[i] == tmp) {
                    min[i] = 0;
                } else {
                    min[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == 1) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());
        } else if(arr[0] == 9){
            int tmp = 0;
            max[0] = 9;
            for (int i = 1; i < n; ++i) {
                if(arr[i] != 9) {
                    tmp = arr[i];
                    break;
                }
            }
            for (int i = 1; i < n; ++i) {
                if(arr[i] == tmp) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == 9) {
                    min[i] = 1;
                }else {
                    min[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());


        } else {
            int tmp = arr[0];
            for (int i = 0; i < n; ++i) {
                if(arr[i] == tmp) {
                    max[i] = 9;
                }else {
                    max[i] = arr[i];
                }
            }
            for (int i = 0; i < n; ++i) {
                if(arr[i] == tmp) {
                    min[i] = 1;
                }else {
                    min[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; ++i) {
                sb.append(max[i] - min[i]);
            }
            return Integer.parseInt(sb.toString());
        }


    }
}
