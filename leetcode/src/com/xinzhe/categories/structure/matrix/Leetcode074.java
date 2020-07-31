package com.xinzhe.categories.structure.matrix;

/**
 * @author Xin
 * @date 2020/4/7 15:53
 * Title : 74. 搜索二维矩阵
 * Description : 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *              每行中的整数从左到右按升序排列。
 *              每行的第一个整数大于前一行的最后一个整数。
 * link : https://leetcode-cn.com/problems/search-a-2d-matrix
 * Level : Medium
 */

public class Leetcode074 {
    public static void main(String[] args) {
        int[][] a = {{1,3}};
        System.out.println(searchMatrix(a, 4));
    }
    //两次循环 O(n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m-1][n-1] < target) return false;
        int cur = 1;
        if(m == 1) {
            cur = m;
        } else {
            for(int i = 1; i < m; ++i) {
                if(matrix[i][0] == target) return true;
                if(i == m-1 && matrix[i][0] < target) {
                    cur = m; break;
                }
                if(matrix[i][0] > target){
                    cur = i; break;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if(matrix[cur-1][i] == target){
                return true;
            }
        }
        return false;
    }
    //二分法
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m*n-1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (matrix[mid / n][mid % n] < target){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return matrix[left/n][left % n] == target;
    }

}
