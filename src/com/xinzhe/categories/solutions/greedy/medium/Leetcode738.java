package com.xinzhe.categories.solutions.greedy.medium;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/5/25
 * Title : 738. 单调递增的数字
 * Description : 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *              （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
 * link : https://leetcode-cn.com/problems/monotone-increasing-digits
 * Level : Medium
 */

public class Leetcode738 {

    public int monotoneIncreasingDigits(int N) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        for (char v : String.valueOf(N).toCharArray()) {
            if(flag) {
                stack.push(9);
            } else {
                int c = v - '0';
                if(stack.isEmpty()) {
                    stack.push(c);
                } else {
                    int peek = stack.peek();
                    if(peek > c) {
                        int cnt = 0;
                        while (!stack.isEmpty() && stack.peek() == peek) {
                            stack.pop();
                            cnt++;
                        }
                        stack.push(peek - 1);
                        while (cnt-- > 0) {
                            stack.push(9);
                        }
                        flag = true;
                    } else {
                        stack.push(c);
                    }
                }
            }

        }
        int x = 0, ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop() * Math.pow(10, x++);
        }
        return ans;
    }
}
