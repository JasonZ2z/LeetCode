package com.xinzhe.categories.structure.matrix;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/10/13
 * Title : 85. 最大矩形
 * Description : 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * link : https://leetcode-cn.com/problems/maximal-rectangle/
 * Level : Hard
 */
//todo need to review
//same as 84. 柱状图中最大的矩形
public class Leetcode085 {
    public static void main(String[] args) {
        Leetcode085 lc = new Leetcode085();
        char[][] arr = {
                {'0','1','1','0','1'},
                {'1','1','0','1','0'},
                {'0','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'}};
        System.out.println(lc.maximalRectangle(arr));
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length; if(m == 0) return 0;
        int n = matrix[0].length; if(n == 0) return 0;
        int[] h = new int[n+2];
        int max = 0;
        for (char[] arr : matrix) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < n + 2; ++j) {
                if (j > 0 && j < n + 1) h[j] = arr[j - 1] == '1' ? h[j] + 1 : 0;
                while (!list.isEmpty() && h[j] < h[list.peekLast()]) {
                    int index = list.pollLast();
                    while (!list.isEmpty() && h[list.peekLast()] == h[index]) list.pollLast();
                    max = Math.max(max, h[index] * (j - list.peekLast() - 1));
                }
                list.addLast(j);
            }
        }
        return max;
    }
}
