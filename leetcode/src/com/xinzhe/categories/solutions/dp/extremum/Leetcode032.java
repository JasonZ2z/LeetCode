package com.xinzhe.categories.solutions.dp.extremum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/7/4
 * Title : 32. 最长有效括号
 * Description : 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * link : https://leetcode-cn.com/problems/longest-valid-parentheses/
 * Level : Hard
 */
public class Leetcode032 {
    //todo
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
