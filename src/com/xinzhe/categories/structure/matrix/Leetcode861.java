package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/12/07
 * Title : 861. 翻转矩阵后的得分
 * Description : 有一个二维矩阵A 其中每个元素的值为0或1。移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *              在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。返回尽可能高的分数。
 * link : https://leetcode-cn.com/problems/score-after-flipping-matrix
 * Level : Medium
 */

public class Leetcode861 {
    public static void main(String[] args) {
        Leetcode861 lc = new Leetcode861();
        int[][] arr = {{0,0,1,1}, {1,0,1,0},{1,1,0,0}};
        System.out.println(lc.matrixScore(arr));
    }
    public int matrixScore(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        for (int i = 0; i < m; ++i) {
            if(arr[i][0] == 0) {
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = arr[i][j] == 0 ? 1 : 0;
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            int cnt = 0;
            for (int j = 0; j < m; ++j) {
                cnt += arr[j][i];
            }
            if(cnt < (m + 1)/2) {
                for (int j = 0; j < m; ++j) {
                    arr[j][i] = arr[j][i] == 0 ? 1 : 0;
                }
            }
        }
        int res = 0;
        for (int[] tmp : arr) {
            int x = 0;
            for (int i = 0; i < n; ++i) {
                x = (x << 1) + tmp[i];
            }
            res += x;
        }
        return res;
    }
}
