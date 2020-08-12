package com.xinzhe.categories.structure.sort.implement;

/**
 * @author Xin
 * @date 2020/4/24
 * Title : 面试题51. 数组中的逆序对
 * Description : 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * link : https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * Level : Hard
 */

public class Interview051 {
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n <= 1) return count;
        merge(nums, 0, n-1);
        return count;
    }

    private void merge(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            merge(nums, left, mid);
            merge(nums, mid+1, right);
            combine(nums, left, mid, right);
        }
    }

    private void combine(int[] nums, int left, int mid, int right) {
        if(nums[mid] < nums[mid+1]) return;
        int[] arr = new int[right - left + 1];
        int i = left, j = mid+1, index = 0;
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j]) {
                arr[index++] = nums[i++];
            }
            if (nums[i] > nums[j] && i<= mid) {
                arr[index++] = nums[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            arr[index++] = nums[i++];
        }
        while (j <= right) {
            arr[index++] = nums[j++];
        }
        System.arraycopy(arr, 0, nums, left, index);
    }

    public static void main(String[] args) {
        Interview051 i = new Interview051();
        int[] nums = {7,5,6,4};
        System.out.println(i.reversePairs(nums));
    }
}
