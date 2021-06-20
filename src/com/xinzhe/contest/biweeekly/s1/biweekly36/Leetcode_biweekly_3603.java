package com.xinzhe.contest.biweeekly.s1.biweekly36;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/10/3
 * Title : 1605. 给定行和列的和求可行矩阵
 * Description : 给你两个非负整数数组rowSum 和colSum，其中rowSum[i]是二维矩阵中第 i行元素的和， colSum[j]是第 j列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 *              请找到大小为rowSum.length x colSum.length的任意 非负整数矩阵，且该矩阵满足rowSum 和colSum的要求。
 *              请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个可行矩阵。
 * link : https://leetcode-cn.com/problems/find-valid-matrix-given-row-and-column-sums
 * Level : Medium
 */
public class Leetcode_biweekly_3603 {
    public static void main(String[] args) {
        Leetcode_biweekly_3603 lc = new Leetcode_biweekly_3603();
        int[] row = {5,7,10};
        int[] c = {8,6,8};
        System.out.println(Arrays.deepToString(lc.restoreMatrix(row, c)));

    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int inf = (int)1e9;

        int[][] res = new int[m][n];

        while(true) {
            int min;
            int r = 0, c = 0, min1 = inf, min2 = inf;
            for (int i = 0; i < m; ++i) {
                if(rowSum[i] < min1) {
                    min1 = rowSum[i];
                    r = i;
                }
            }
            for (int i = 0; i < n; ++i) {
                if(colSum[i] < min2) {
                    min2 = colSum[i];
                    c = i;
                }
            }
            min = Math.min(min1, min2);
            res[r][c] = min;
            rowSum[r] -= min;
            if(rowSum[r] == 0) rowSum[r] = inf;
            colSum[c] -= min;
            if(colSum[c] == 0) colSum[c] = inf;

            boolean flag = false;
            for (int j : rowSum) {
                if (j != inf) {
                    flag = true;
                    break;
                }
            }
            if(!flag) break;

        }
        return res;
    }
}
