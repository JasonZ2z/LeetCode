package com.xinzhe.contest.weekly.season04.weekly200;

/**
 * @author Xin
 * @date 2020/8/2
 * Title : 1536. 排布二进制网格的最少交换次数
 * Description : 给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 *              请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 * link : https://leetcode-cn.com/problems/minimum-swaps-to-arrange-a-binary-grid
 * Level : Medium
 */
//todo need to review
public class Leetcode_weekly_20003 {
    public static void main(String[] args) {
        Leetcode_weekly_20003 lc = new Leetcode_weekly_20003();
        int[][] g = {{1,0,0,0,0,0},{0,0,0,1,0,0},{0,0,0,1,0,0},{0,0,1,0,0,0},{0,1,0,0,0,0},{0,0,0,0,0,1}};
        System.out.println(lc.minSwaps(g));
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];
        // record first zero index of each row
        for (int i = 0; i < n; ++i) {
            for(int j = n-1; j >= 0; --j) {
                if(grid[i][j] == 1) {
                    arr[i] = j;
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] <= i) continue;
            int j = i+1;
            for (; j < n ; j++) {
               if(arr[j] <= i){
                   break;
               }
            }
            if(j == n) return -1;
            for(int k = j; k > i; --k) {
                int tmp = arr[k-1];
                arr[k-1] = arr[k];
                arr[k] = tmp;
                res++;
            }
        }
        return res;
    }
}
