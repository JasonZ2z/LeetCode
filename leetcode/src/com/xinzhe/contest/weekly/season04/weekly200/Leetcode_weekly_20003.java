package com.xinzhe.contest.weekly.season04.weekly200;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_20003 {
    public static void main(String[] args) {
        Leetcode_weekly_20003 lc = new Leetcode_weekly_20003();
        int[][] g = {{1,0,0,0,0,0},{0,0,0,1,0,0},{0,0,0,1,0,0},{0,0,1,0,0,0},{0,1,0,0,0,0},{0,0,0,0,0,1}};
        System.out.println(lc.minSwaps(g));
    }

    public int minSwaps(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if(grid[j][i] == 1) {
                    count++;
                }
            }
            if(count > n-i) {
                return -1;
            }
            arr[i] = count;
        }
//        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = i; j < n - 1; j++) {
                if(getZeros(grid, j) <= getZeros(grid, j+1)){
                    int[] tmp = grid[j];
                    grid[j] = grid[j+1];
                    grid[j+1] = tmp;
                    flag = false;
                    res++;
                }
            }
            if(flag){
                break;
            }
        }

//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i; j < n; j++) {
//                if(getZeros(grid, j) <= getZeros(grid, j+1)){
//                    swap(grid, j);
//                    res++;
//                }
//            }
//        }
        return res;

    }

    private void swap(int[][] grid, int j) {
        if(j+ 1 < grid.length){
            int[] tmp = grid[j];
            grid[j] = grid[j+1];
            grid[j+1] = tmp;
        }

    }

    private int getZeros(int[][] g, int i) {
        int n = g.length;
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if(j > i && g[i][j] == 0) {
                count++;
            }
        }
        return count;
    }
    private boolean check(int[][] g) {
        int n = g.length;
        for (int i = 0; i < n-1; ++i) {
            for (int j = i+1; j < n; ++j) {
                if(g[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
