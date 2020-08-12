package com.xinzhe.categories.structure.stack;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/4/4 16:29
 * Title : 84. 柱状图中最大的矩形
 * Description : 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * link : https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * Level : Hard
 */
public class Leetcode084 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        if(n == 1) return heights[0];

        int max = heights[0];

        int[] arr = new int[n+2];
        arr[0] = 0;
        System.arraycopy(heights, 0, arr, 1, n);
        arr[n+1] = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n+2; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int cur = arr[stack.pop()];
                while (!stack.isEmpty() && arr[stack.peek()] == cur){
                    stack.pop();
                }
                int width = i - stack.peek() - 1;
                max = Math.max(max, width * cur);
            }
            stack.add(i);
        }
        return max;
    }
}
