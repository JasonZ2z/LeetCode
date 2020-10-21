package com.xinzhe.categories.structure.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/10/21
 * Title : 581. 最短无序连续子数组
 * Description : 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *              你找到的子数组应是最短的，请输出它的长度。
 * link : https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * Level : Medium
 */
//todo need to review
public class Leetcode581 {
    public static void main(String[] args) {
        Leetcode581 lc = new Leetcode581();
        int[] q = {3,1,10,10,1};
        int[] w = {4,8,2,2,7};
    }

    public int findUnsortedSubarray3(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int l = n-1, r = 0;
        for(int i = 0; i<n; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                l = Math.min(l , stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i =n-1; i>=0; i--) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                r = Math.max(r , stack.pop());
            }
            stack.push(i);
        }
        return r > l ? r - l + 1: 0;
    }
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] clone = new int[n];
        System.arraycopy(nums, 0, clone, 0, n);
        Arrays.sort(clone);
        int ans =0;
        for(int p=0; p < n; p++) {
            if(clone[p] == nums[p]){
                ans++;
            } else {
                break;
            }
        }
        if( ans == n) return 0;
        for(int p=n-1; p >= 0; p--) {
            if(clone[p] == nums[p]){
                ans++;
            } else {
                break;
            }
        }
        return n - ans;
    }
}
