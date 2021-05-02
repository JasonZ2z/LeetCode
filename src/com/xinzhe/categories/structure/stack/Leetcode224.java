package com.xinzhe.categories.structure.stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Xin
 * @date 2021/03/10
 * Title : 224. 基本计算器
 * Description : 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * link : https://leetcode-cn.com/problems/basic-calculator/
 * Level : Hard
 */
public class Leetcode224 {
    public static void main(String[] args) {
        Set<Long> set = new HashSet<>();
        set.add(1L);
        System.out.println(set.contains(1));
    }
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

}
