package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.Stack;

/**
 * @author Xin
 * @date 2020/10/11
 * Title :
 * Description :
 * link :
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
