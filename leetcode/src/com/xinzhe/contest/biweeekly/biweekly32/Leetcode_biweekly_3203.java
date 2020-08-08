package com.xinzhe.contest.biweeekly.biweekly32;

import java.util.Stack;

/**
 * @Author Xin
 * @create 2020/8/8
 * Title :
 * Description :
 * link :
 * Level :
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
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            s1.push(s.charAt(i));
        }

        while (!s1.isEmpty()) {
            while (s1.size() > 0 && s1.peek() == ')') {
                s2.push(s1.pop());
            }
            if(s1.size() > 0 && s1.peek() == '(') {
                if(s2.size() % 2 == 1) {
                    s2.push(')');
                    res++;
                }
                if(s2.size() > 1) {
                    s2.pop();
                    s2.pop();
                } else {
                    res += 2;
                }
                s1.pop();
            }
        }
        if(!s2.isEmpty()) {
            int size =  s2.size();
            if(size % 2 == 0) {
                res += size /2;
            } else {
                res += (size + 1)/2 + 1;
            }
        }
        return res;
    }
}
