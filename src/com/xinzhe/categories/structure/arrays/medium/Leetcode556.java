package com.xinzhe.categories.structure.arrays.medium;

/**
 * @author Xin
 * @date 2020/11/18
 * Title : 556. 下一个更大元素 III
 * Description : 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 * link : https://leetcode-cn.com/problems/next-greater-element-iii/
 * Level : Medium
 */

public class Leetcode556 {
    public int nextGreaterElement(int m) {
        char[] arr = String.valueOf(m).toCharArray();
        int n = arr.length;
        int index = -1;

        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) {
                index = i-1;
            }
        }
        if(index == -1) return -1;

        int minVal = arr[index + 1];
        int minIndex = index + 1;
        for(int i = index + 1; i<n; i++) {
            if(arr[i] > arr[index] && arr[i] <= minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }
        swap(arr, index, minIndex);
        reverse(arr, index + 1, n-1);
        long ans = Long.parseLong(new String(arr));
        if(ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }

    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(char[] arr, int l, int r) {
        if(l == r) return;
        while(l < r) {
            swap(arr, l++ ,r--);
        }
    }
}
