package com.xinzhe.contest.weekly.season06.weekly262;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/10/10
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26202 {
    public static void main(String[] args) {
        Leetcode_weekly_26202 lc = new Leetcode_weekly_26202();
//        int[][] arr = {{2,4}, {6,8}};
//        System.out.println(lc.minOperations(arr, 2));
        //int[][] arr = {{931,128}, {639,712}};
//        int[][] arr = {{980,476,644,56},{644,140,812,308},{812,812,896,560},{728,476,56,812}};
        int[][] arr = {{454,328,160,286,664},{496,538,748,244,286},{34,244,454,706,790},{496,538,832,958,328},{370,874,370,874,286}};
        System.out.println(lc.minOperations(arr, 42));
        System.out.println(lc.minOperations2(arr, 42));

    }



    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        if(m * n == 1) return 0;
        if(x != 1) {
            int flag = grid[0][0] % x;
            for (int[] g : grid) {
                for (int j = 0; j < n; ++j) {
                    if(g[j] % x != flag) return -1;
                }
            }
        }
        int[] arr = new int[m * n];
        int k = 0;
        for (int[] g : grid) {
            for (int j = 0; j < n; ++j) {
                arr[k++] = g[j];
            }
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int l = 0, r = (arr[m*n-1] - arr[0] + x)/ x;
        while (l < r) {
            int mid = (l + r) / 2;
            int check = check(arr, x, mid);
            if(check < min) {
                min = check;
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(check(arr, x, l));
        return min;

    }

    private int check(int[] arr, int x, int t) {
        int count = 0;
        int mid = arr[0] + t * x;
        for (int i : arr) {
            count += Math.abs(i - mid) / x;
        }
        return count;
    }


    public int minOperations2(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        if (m * n == 1) return 0;
        if (x != 1) {
            int flag = grid[0][0] % x;
            for (int[] g : grid) {
                for (int j = 0; j < n; ++j) {
                    if (g[j] % x != flag) return -1;
                }
            }
        }
        int[] arr = new int[m * n];
        int k = 0;
        for (int[] g : grid) {
            for (int j = 0; j < n; ++j) {
                arr[k++] = g[j];
            }
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = arr[0], v = 0; i+v*x <= arr[m*n-1]; ++v) {
            int zz = check2(arr, x, i+v*x);
            if(zz <= min) {
                min = zz;
            }else {
                return min;
            }
        }
        return min;

    }

    private int check2(int[] arr, int x, int mid) {
        int count = 0;
        for (int i : arr) {
            count += Math.abs(i - mid) / x;
        }
        return count;
    }

}
