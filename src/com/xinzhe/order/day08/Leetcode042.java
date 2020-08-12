package com.xinzhe.order.day08;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/4/4 15:09
 * Title : 42. 接雨水
 * Description : 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * link : https://leetcode-cn.com/problems/trapping-rain-water/
 * Level : Hard
 */
public class Leetcode042 {

    //先找到最大值，分别从左和右归纳到最大值
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3) return 0;
        int res = 0;
        int max = height[0];
        int max_index = 0;
        for (int i = 1; i < n; ++i) {
            if(height[i] > max){
                max = height[i];
                max_index = i;
            }
        }
        int left = height[0];
        for (int i = 1; i < max_index; ++i) {
            if(height[i] > left) {
                left = height[i];
            } else {
                res += left - height[i];
            }
        }
        int right = height[n-1];
        for (int i = n-2; i > max_index; --i) {
            if(height[i] > right){
                right = height[i];
            }else {
                res += right - height[i];
            }
        }
        return res;
    }
    //单调栈
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    int top = stack.peek();
                    res += (Math.min(height[top], height[i]) - height[cur]) * (i - top - 1);
                }
            }
            stack.add(i);
        }
        return res;
    }
}
