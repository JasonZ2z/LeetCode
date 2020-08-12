package com.xinzhe.categories.structure.arrays.easy;

/**
 * @author Xin
 * @date 2020/7/30
 * Title : 27. 移除元素
 * Description : 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *              不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * link : https://leetcode-cn.com/problems/remove-element
 * Level : Easy
 */
public class Leetcode027 {
    public static void main(String[] args) {
        Leetcode027 lc = new Leetcode027();
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(lc.removeElement3(arr,2));
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        for(int j =0; j<n; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int start = 0;
        while(start < n){
            if(nums[start] == val) {
                break;
            }
            start++;
        }
        if(start == n-1 || start == n) return start;
        int i=start, j=start+1;
        while(j < n) {
            while(i < j && nums[i] != val) {
                i++;
            }
            if(nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
                i++;
            }
            j++;
        }
        return i;
    }

    public int removeElement3(int[] nums, int val) {
        int n = nums.length;
        int i=0, j=0;
        while(j < n) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
