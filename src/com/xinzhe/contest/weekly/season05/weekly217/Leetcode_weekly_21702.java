package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/11/29
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21702 {
    public static void main(String[] args) {
        Leetcode_weekly_21702 lc = new Leetcode_weekly_21702();
        int[] arr = {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(lc.mostCompetitive(arr, 4)));
    }
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        if(n == k) return nums;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + (n -1) - i >= k) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] tmp = new int[k];

        while (!stack.isEmpty()) {
            if(stack.size() > k) {
                stack.pop();
            } else {
                tmp[--k] = stack.pop();
            }

        }
        return tmp;
    }
}
