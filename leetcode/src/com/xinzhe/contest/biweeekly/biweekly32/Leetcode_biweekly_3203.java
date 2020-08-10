package com.xinzhe.contest.biweeekly.biweekly32;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/8/8
 * Title : 1541. 平衡括号字符串的最少插入次数
 * Description : 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 *          任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 *          左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 *          比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 *          你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。请你返回让 s 平衡的最少插入次数。
 * link : https://leetcode-cn.com/problems/minimum-insertions-to-balance-a-parentheses-string
 * Level : Medium
 */
public class Leetcode_biweekly_3203 {
    public static void main(String[] args) {
        Leetcode_biweekly_3203 lc = new Leetcode_biweekly_3203();
        String s = "(()))(()))()())))";
        System.out.println(lc.minInsertions(s));
    }

    public int minInsertions(String s) {
        int res = 0;
        Stack<Character> s1 = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            s1.push(s.charAt(i));
        }

        while (!s1.isEmpty()) {
            while (s1.size() > 0 && s1.peek() == ')') {
                s1.pop();
                count++;
            }
            if(s1.size() > 0 && s1.peek() == '(') {
                if(count % 2 == 1) {
                    count++;
                    res++;
                }
                if(count > 1) {
                    count -= 2;
                } else {
                    res += 2;
                }
                s1.pop();
            }
        }
        if(count != 0) {
            if(count % 2 == 0) {
                res += count /2;
            } else {
                res += (count + 1)/2 + 1;
            }
        }
        return res;
    }
}
