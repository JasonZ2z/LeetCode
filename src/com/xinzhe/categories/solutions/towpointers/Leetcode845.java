package com.xinzhe.categories.solutions.towpointers;

/**
 * @author Xin
 * @date 2020/10/25
 * Title : 845. 数组中的最长山脉
 * Description : 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：B.length >= 3
 *              存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 *              （注意：B 可以是 A 的任意子数组，包括整个数组 A。）给出一个整数数组 A，返回最长 “山脉” 的长度。如果不含有 “山脉” 则返回 0。
 * link : https://leetcode-cn.com/problems/longest-mountain-in-array
 * Level : Medium
 */
public class Leetcode845 {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,4,3,2,1,0};
        Leetcode845 lc = new Leetcode845();
        System.out.println(lc.longestMountain(a));
    }
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int l = 0, r = 0, max = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i-1]) {
                if(r == 0) l++;
                else {
                    if(r > 0) max = Math.max(max, l + r + 1);
                    r = 0;
                    l = 1;
                }
            } else if(arr[i] == arr[i-1]){
                l = 0;
                r = 0;
            } else {
                if(l > 0) {
                    r++;
                    max = Math.max(max, l + r + 1);
                }
            }
        }
        return max;
    }
}
