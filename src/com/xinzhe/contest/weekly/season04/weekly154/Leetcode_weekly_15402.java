package com.xinzhe.contest.weekly.season04.weekly154;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Xin
 * @create 2020/7/28
 * Title : 1190. 反转每对括号间的子串
 * Description : 给出一个字符串 s（仅含有小写英文字母和括号）。请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *              注意，您的结果中 不应 包含任何括号。
 * link : https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * Level : Medium
 */

public class Leetcode_weekly_15402 {

    public static void main(String[] args) {
        Leetcode_weekly_15402 lc = new Leetcode_weekly_15402();
        System.out.println(lc.reverseParentheses("ta()usw((((a))))"));
    }

    public String reverseParentheses(String s) {
        if(s == null || "".equals(s)) return "";
        int n = s.length();
        char[] arr = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if(stack.isEmpty() || Character.isLetter(arr[i]) ||arr[i] == '(') {
                stack.push(arr[i]);
            } else if(arr[i] == ')') {
                StringBuilder sb = new StringBuilder();
                while ('(' != stack.peek()) {
                    sb.append(stack.pop());
                }
                stack.pop();
                String tmp = sb.toString();
                if(!"".equals(tmp)) {
                    int j = 0;
                    while (j < tmp.length()) {
                        stack.push(tmp.charAt(j++));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
