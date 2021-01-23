package com.xinzhe.contest.biweeekly.biweekly43;

import java.util.Stack;

/**
 * @author Xin
 * @date 2021/01/09
 * Title : 1717. 删除子字符串的最大得分
 * Description : 给你一个字符串s和两个整数x 和y。你可以执行下面两种操作任意次。
 *              删除子字符串"ab"并得到x分。比方说，从"cabxbae"删除 ab，得到"cxbae"。
 *              删除子字符串"ba"并得到y分。比方说，从"cabxbae"删除 ba，得到"cabxe"。
 *              请返回对 s字符串执行上面操作若干次能得到的最大得分。
 * link : https://leetcode-cn.com/problems/maximum-score-from-removing-substrings
 * Level : Medium
 */
public class Leetcode_biweekly_4302 {
    public static void main(String[] args) {
        Leetcode_biweekly_4302 lc = new Leetcode_biweekly_4302();
        String s = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
        System.out.println(lc.maximumGain2(s, 1926, 4320));
    }

    public int maximumGain2(String s, int x, int y) {
        if(s.length() == 1) return 0;
        Stack<Character> stack = new Stack<>();
        Stack<Character> s2= new Stack<>();
        char[] arr = s.toCharArray();
        int res = 0;
        if(y >= x) { //ba
            for (char value : arr) {
                if (value == 'a' && !stack.isEmpty() && stack.peek() == 'b') {
                    stack.pop();
                    res += y;
                } else {
                    stack.push(value);
                }
            }

            while (!stack.isEmpty()) {
                char c = stack.pop();
                s2.push(c);
                while (!stack.isEmpty() && !s2.isEmpty()) {
                    if(stack.peek() == 'a' && s2.peek() == 'b') {
                        res += x;
                        stack.pop();
                        s2.pop();
                    } else {
                        break;
                    }
                }
            }
        } else {
            for (char value : arr) {
                if (value == 'b' && !stack.isEmpty() && stack.peek() == 'a') {
                    stack.pop();
                    res += x;
                } else {
                    stack.push(value);
                }
            }

            while (!stack.isEmpty()) {
                char c = stack.pop();
                s2.push(c);
                while (!stack.isEmpty() && !s2.isEmpty()) {
                    if(stack.peek() == 'b' && s2.peek() == 'a') {
                        res += y;
                        stack.pop();
                        s2.pop();
                    } else {
                        break;
                    }
                }
            }
        }
        return res;

    }
}