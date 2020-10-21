package com.xinzhe.contest.weekly.season03.weekly120;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 977. 有序数组的平方
 * Description : 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * link : https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * Level : Easy
 */

public class Leetcode_weekly_12001 {
    public static void main(String[] args) {
        Leetcode_weekly_12001 lc = new Leetcode_weekly_12001();
    }
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int p = 0, q = n-1, i = n-1;
        while(p <= q) {
            if(A[p] * A[p] < A[q] * A[q]) {
                res[i--] = A[q] * A[q];
                q--;
            } else {
                res[i--] = A[p] * A[p];
                p++;
            }
        }
        return res;
    }
}
