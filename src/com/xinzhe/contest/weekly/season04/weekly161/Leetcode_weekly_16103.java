package com.xinzhe.contest.weekly.season04.weekly161;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/6/20
 * Title : 1249. 移除无效的括号
 * Description : 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *              你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。请返回任意一个合法字符串。
 *      有效「括号字符串」应当符合以下 任意一条 要求：
 *          空字符串或只包含小写字母的字符串
 *          可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 *          可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * link : https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * Level : Medium
 * Comment 161周赛03
 */

public class Leetcode_weekly_16103 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
    public static String minRemoveToMakeValid(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(!Character.isLetter(arr[i])) {
                if(arr[i] == '(') {
                    stack.push(i);
                }else {
                    if(stack.isEmpty()) {
                        arr[i] = ' ';
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = ' ';
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if(c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
