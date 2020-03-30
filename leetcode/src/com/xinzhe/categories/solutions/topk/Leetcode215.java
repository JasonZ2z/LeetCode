package com.xinzhe.categories.solutions.topk;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Author Xin
 * @create 2020/3/12 19:24
 * Title : 215. 数组中的第K个最大元素
 * Description : 给在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * link : https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * Level : Medium
 */
public class Leetcode215 {
    public static void main(String[] args) {
        //int[] arr = {3,2,3,1,2,4,5,5,6};
        //int[] arr = {1};
        int[] arr = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        //int[] arr = {-1,-1};
        System.out.println(findKthLargest(arr, 2));
        System.out.println(findKthLargest2(arr, 2));
        System.out.println(findKthLargest3(arr, 2));
    }
    //快速选择排序
    public static int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length- 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if(left <right){
            int index = partition(nums, left, right);
            if(index < k){
                return quickSelect(nums, index+1, right, k);
            } else if (index == k){
                return nums[k];
            } else {
                return quickSelect(nums, left, index-1,k);
            }
        }
        return nums[k];
    }

    private static int partition(int[] arr, int start, int end) {
        Random ran = new Random();
        int anchor = start + ran.nextInt(end - start);
        int left = start;
        int right = end;
        while(left < right){
            while(arr[right] > arr[anchor] && right>left){
                right--;
            }
            while(arr[left] <= arr[anchor] && right > left){
                left++;
            }
            if(right > left){
                swap(arr, right, left);
            }
        }
        swap(arr, anchor, left);

        return left;
    }

    //堆排序
    public static int findKthLargest2(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
    //冒泡排序
    public static int findKthLargest(int[] nums, int k) {
        if(nums.length < k) return 0;
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n -1- i; j++) {
                if(nums[j+1] < nums[j]){
                    swap(nums, j, j+1);
                }
            }
            if(i+1 == k){
                break;
            }
        }
        return nums[n-k];
    }

    private static void swap(int[] nums, int j, int i) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }


}
