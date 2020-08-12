package com.xinzhe.categories.structure.matrix;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/4/7 15:53
 * Title : 378. 有序矩阵中第K小的元素
 * Description : 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * link : https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Level : Medium
 */

public class Leetcode378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int[] m : matrix) {
            for (int j = 0; j < n; ++j) {
                queue.offer(m[j]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];

        while (min < max) {
            int mid = min + ((max - min) >> 1);
            if(count(matrix, mid, k)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private boolean count(int[][] matrix, int mid, int k) {
        int res = 0;
        int i = 0, j= matrix.length -1;
        while (i < matrix.length && j >= 0) {
            if(matrix[j][i] <= mid) {
                res += j + 1;
                i++;
            } else {
                j--;
            }
            if(res >= k) return false;
        }
        return true;
    }
}
