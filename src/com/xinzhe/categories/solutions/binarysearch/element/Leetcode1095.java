package com.xinzhe.categories.solutions.binarysearch.element;

/**
 * @author Xin
 * @date 2020/4/8 14:56
 * Title : 1095. 山脉数组中查找目标值
 * Description : 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。如果不存在这样的下标 index，就请返回 -1。
 *          何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *          首先，A.length >= 3
 *          其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *              A[0] < A[1] < ... A[i-1] < A[i]
 *              A[i] > A[i+1] > ... > A[A.length - 1]
 *          你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *              MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 *              MountainArray.length() - 会返回该数组的长度
 * link : https://leetcode-cn.com/problems/find-in-mountain-array
 * Level : Hard
 */

public class Leetcode1095 {
    //          mid
    //0,1,2,3,4,5,6,7,8,7,6,5
    //0,2,4,6,8,7,6,5,4,3,2,1

    public static void main(String[] args) {
        int[] arr = {0,5,3,1};
        int target = 3;
        System.out.println(findInMountainArray(target, arr));
    }

    public static int findInMountainArray(int target, int[] arr) {
        int n = arr.length;
        int topIndex = getTop(arr, 0, n-1);
        if(target == arr[topIndex]) return topIndex;
        if(target > arr[topIndex]) return -1;
        int res = searchInOrder(arr, 0, topIndex-1, target);
        return res == -1 ? searchReverseOrder(arr, topIndex+1, n-1, target) : res;
    }

    private static int getTop(int[] arr, int left, int right){
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int searchInOrder(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }
    private static int searchReverseOrder(int[] arr, int left, int right, int target) {
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > target){
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return arr[left] == target ? left : -1;
    }
}