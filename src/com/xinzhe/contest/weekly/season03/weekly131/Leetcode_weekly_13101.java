package com.xinzhe.contest.weekly.season03.weekly131;

import java.util.ArrayDeque;

/**
 * @author Xin
 * @date 2020/9/17
 * Title : 1021. 删除最外层的括号
 * Description : 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *              如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *              给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *              对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * link : https://leetcode-cn.com/problems/remove-outermost-parentheses
 * Level : Easy
 */

public class Leetcode_weekly_13101 {
    public static void main(String[] args) {
        Leetcode_weekly_13101 lc = new Leetcode_weekly_13101();
    }
    public String removeOuterParentheses(String s) {
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>(n);
        StringBuilder sb = new StringBuilder();
        int diff = 0, i = 0;
        while(i < n) {
            char c = s.charAt(i++);
            if(c == '(') {
                diff++;
                stack.push(c);
            }
            else{
                diff--;
                if(diff == 0) {
                    StringBuilder tmp = new StringBuilder();
                    while (stack.size() != 1) {
                        tmp.append(stack.pop());
                    }
                    sb.append(tmp.reverse().toString());
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return sb.toString();
    }
}
