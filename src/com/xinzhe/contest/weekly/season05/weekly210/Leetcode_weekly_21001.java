package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/10/11
 * Title : 1614. 括号的最大嵌套深度
 * Description : 如果字符串满足一下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 *              给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
 * link : https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 * Level : Easy
 */
public class Leetcode_weekly_21001 {
    public static void main(String[] args) {
        Leetcode_weekly_21001 lc = new Leetcode_weekly_21001();
        int[] arr = {3,5};
    }

    public int maxDepth(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == ')') {
                sb.append(c);
            }
        }
        if(sb.length() <= 1) return 0;
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (char c : sb.toString().toCharArray()) {
            if(c == '(') {
                stack.push(c);
                max = Math.max(max, stack.size());
            } else {
                stack.pop();
            }

        }
        return max;

    }
}
