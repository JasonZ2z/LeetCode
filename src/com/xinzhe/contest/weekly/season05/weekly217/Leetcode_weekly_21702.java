package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Xin
 * @date 2020/11/29
 * Title : 1673. 找出最具竞争力的子序列
 * Description : 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 *              在子序列a 和子序列b 第一个不相同的位置上，如果a中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 *              例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上，4 小于 5 。
 * link : https://leetcode-cn.com/problems/find-the-most-competitive-subsequence
 * Level : Medium
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
