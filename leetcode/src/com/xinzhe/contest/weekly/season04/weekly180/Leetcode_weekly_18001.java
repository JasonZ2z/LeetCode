package com.xinzhe.contest.weekly.season04.weekly180;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/3/16 19:41
 * Title : 5356. 矩阵中的幸运数
 * Description : 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * link : https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
 * Level : Easy
 * Comment 180周赛01
 */
public class Leetcode_weekly_18001 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n= matrix[0].length;

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    k = j;
                }
            }
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if(matrix[j][k] > min) {
                    flag = false;
                    break;
                }
            }
            if(flag){
               list.add(min);
            }
        }
        return list;
    }
}
