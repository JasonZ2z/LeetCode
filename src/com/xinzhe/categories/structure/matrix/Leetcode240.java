package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/4/7 15:53
 * Title : 240. 搜索二维矩阵 II
 * Description : 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *              每行的元素从左到右升序排列。
 *              每列的元素从上到下升序排列。
 * link : https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * Level : Medium
 */

public class Leetcode240 {
    public static void main(String[] args) {
        int[][] a = {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(a, 5));

    }
    //左下角的二分法
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || matrix[m-1][n-1] < target) return false;
        int i= m-1, j=0;
        while (i >= 0 && j < n){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) j++;
            else i--;
        }
        return false;
    }
}
