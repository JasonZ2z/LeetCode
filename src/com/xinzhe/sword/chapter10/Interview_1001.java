package com.xinzhe.sword.chapter10;

/**
 * @author Xin
 * @date 2020/11/12
 * Title : 10.01. 合并排序的数组
 * Description : 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。初始化A 和 B 的元素数量分别为 m 和 n
 * link : https://leetcode-cn.com/problems/sorted-merge-lcci
 * Level : Easy
 */
public class Interview_1001 {
    public static void main(String[] args) {
        Interview_1001 lc = new Interview_1001();
    }
    public void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(B, 0, A, m, n);
        for (int i = 0; i < m+n-1; i++) {
            boolean flag = true;
            for (int j = 0; j < m+n-i-1; j++) {
                if(A[j] > A[j+1]){
                    swap(A, j, j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }
}
