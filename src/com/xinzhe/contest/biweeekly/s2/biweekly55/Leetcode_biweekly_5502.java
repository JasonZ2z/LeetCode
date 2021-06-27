package com.xinzhe.contest.biweeekly.s2.biweekly55;

import java.util.Stack;

/**
 * @author Xin
 * @date 2021/06/26
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5502 {
    public static void main(String[] args) {
        Leetcode_biweekly_5502 lc = new Leetcode_biweekly_5502();
    }

    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();

        int n = part.length();

        for (int i = 0; i < s.length(); ++i) {
            stack.push(s.charAt(i));
            if(stack.size() >= n) {
                boolean flag = true;
                int j = n-1;
                while (!stack.isEmpty() && j >= 0) {
                    if(stack.peek() == part.charAt(j--)) {
                        tmp.push(stack.pop());
                    } else {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    tmp.clear();
                } else {
                    while (!tmp.isEmpty()) {
                        stack.push(tmp.pop());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}