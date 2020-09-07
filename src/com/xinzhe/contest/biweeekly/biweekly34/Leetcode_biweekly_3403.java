package com.xinzhe.contest.biweeekly.biweekly34;

/**
 * @author Xin
 * @date 2020/9/5
 * Title : 1574. 删除最短的子数组使剩余数组有序
 * Description : 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 *              一个子数组指的是原数组中连续的一个子序列。请你返回满足题目要求的最短子数组的长度。
 * link : https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
 * Level : Medium
 */
//todo need to review
public class Leetcode_biweekly_3403 {
    public static void main(String[] args) {
        Leetcode_biweekly_3403 lc = new Leetcode_biweekly_3403();
        int[] arr = {6,3,10,11,15,20,13,3,18,12};
        System.out.println(lc.findLengthOfShortestSubarray(arr));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n-1;
        while(i < n-1 && arr[i] <= arr[i+1]){
            i++;
        }
        if(i == n-1) return 0;
        while(j > 0 && arr[j] >= arr[j-1]){
            j--;
        }
        int res = Math.min(n-i - 1, j);

        int l = 0, r = j;

        while (l <= i && r <= n-1) {
            if(arr[l] <= arr[r]) {
                res = Math.min(res, r - l - 1);
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
