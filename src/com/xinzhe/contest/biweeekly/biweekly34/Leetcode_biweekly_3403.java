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
        int s = 0, e = n-1;
        while(s < n-1 && arr[s] <= arr[s+1]){
            s++;
        }
        if(s == n-1) return 0;
        while(e > 0 && arr[e] >= arr[e-1]){
            e--;
        }
        int res = Math.max(s + 1, n - e);
        for (int i = 0; i <= s; ++i) {
            for (int j = e; j < n; ++j) {
                if(arr[j] >= arr[i]) {
                    res = Math.max(i + 1 + n - j, res);
                }
            }
        }
        return n-res;
    }

    public int findLengthOfShortestSubarray2(int[] arr) {
        int n = arr.length;
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left+1]) {
            left++;
        }
        // [0...left]有序
        if (left == n - 1)  return 0;
        // [right...n-1]有序
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int result = Math.min(n - left - 1, right); // 完全删除一边[left+1, n-1], 或者[0...right - 1]
        int i = 0, j = right; // 左边和右边各保留一部分
        while (i <= left && j <= n - 1) {
            if (arr[i] <= arr[j]) {
                // [0...i] 和 [j...n-1] 有序, 删除 [i+1...j-1]
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                // 小的+1
                j++;
            }
        }
        return result;
    }
}
