package com.xinzhe.categories.solutions.binarysearch.function;

/**
 * @author Xin
 * @date 2020/4/13 18:39
 * Title : 1300. 转变数组后最接近目标值的数组和
 * Description : 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *              如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。请注意，答案不一定是 arr 中的数字。
 * link : https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * Level : Medium
 */

public class Leetcode1300 {
    public static void main(String[] args) {
        int[] arr = {60864,25176,27249,21296,20204};
        System.out.println(findBestValue(arr, 56803));
    }
    public static int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int max = 0, sum = 0;
        for (int i : arr) {
            max = Math.max(max, i);
            sum += i;
        }
        if(sum < target) return 0;
        if(sum == target) return max;

        int left = 1, right = max;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            int cur = add(arr, mid);
            if(cur < target){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        int pre = add(arr, left-1);
        int cur = add(arr, left);
        if(Math.abs(target - pre) <= Math.abs(cur - target)){
            return left -1;
        }
        return left;
    }

    private static int add(int[] arr, int mid) {
        int cur = 0;
        for (int i : arr) {
            cur += Math.min(i, mid);
        }
        return cur;
    }
}
