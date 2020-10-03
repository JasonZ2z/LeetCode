package com.xinzhe.contest.weekly.season05.weekly206;

/**
 * @author Xin
 * @date 2020/9/13
 * Title : 1582. 二进制矩阵中的特殊位置
 * Description : 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 *              特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * link : https://leetcode-cn.com/problems/special-positions-in-a-binary-matrix
 * Level : Easy
 */
public class Leetcode_weekly_20601 {
    public static void main(String[] args) {
        Leetcode_weekly_20601 lc = new Leetcode_weekly_20601();
        //int[][] arr = {{0,0,0,0,0},{1,0,0,0,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};
        int[][] arr = {{0,0},{0,0},{1,0}};
        System.out.println(lc.numSpecial(arr));

    }

    public int numSpecial(int[][] mat) {
        int n = mat[0].length;

        int c = 0;
        for (int[] ints : mat) {
            int sum = 0, index = 0;
            boolean flag = true;
            for (int k = 0; k < n; ++k) {
                if (ints[k] == 1) {
                    sum++;
                    index = k;
                    if (sum > 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag || sum == 0) continue;
            int s = 0;
            for (int[] value : mat) {
                if (value[index] == 1) {
                    s++;
                    if (s > 1) break;
                }
            }
            if (s == 1) c++;
        }
        return c;
    }

}
