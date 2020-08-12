package com.xinzhe.contest.weekly.season05.weekly201;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/8/2
 * Title : 1544. 整理字符串
 * Description : 给你一个由大小写英文字母组成的字符串 s 。一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 *                  0 <= i <= s.length - 2
 *                  s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
 *              请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。请返回整理好的 字符串 。
 *              题目保证在给出的约束条件下，测试样例对应的答案是唯一的。注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * link : https://leetcode-cn.com/problems/make-the-string-great
 * Level : Easy
 */
public class Leetcode_weekly_20101 {
    public static void main(String[] args) {
        Leetcode_weekly_20101 lc = new Leetcode_weekly_20101();
        System.out.println(lc.makeGood("leEeetcode"));
    }
    public String makeGood(String s) {
        int n = s.length();
        if(n == 1) return s;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0;
        while(i < n) {
            if(!stack.isEmpty() && (stack.peek() != arr[i] && Character.toLowerCase(stack.peek()) == Character.toLowerCase(arr[i])) ){
                stack.pop();
            }else {
                stack.push(arr[i]);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
