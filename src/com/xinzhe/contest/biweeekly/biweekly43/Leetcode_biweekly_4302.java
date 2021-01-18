package com.xinzhe.contest.biweeekly.biweekly43;

import java.util.Stack;

/**
 * @author Xin
 * @date 2021/01/09
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_4302 {
    public static void main(String[] args) {
        Leetcode_biweekly_4302 lc = new Leetcode_biweekly_4302();
        int[] arr = {2, 4, 9, 3};
        //"aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha"
        //1926
        //4320
//        String s = "aabbaaxybbaabb";
//        System.out.println(lc.maximumGain2(s, 5, 4));

        String s = "aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha";
        System.out.println(lc.maximumGain2(s, 1926, 4320));
    }
    public int maximumGain(String s, int x, int y) {
        if(s.length() == 1) return 0;
        if(s.startsWith("a") || s.startsWith("b")) {


            return 0;
        } else {
            int l = 0, r = s.length() - 1;
            for (int i = 0; i < s.length() - 1; ++i) {
                if(s.charAt(i) == 'a') {
                    if(s.charAt(i+1) == 'a' || s.charAt(i+1) == 'b') {
                        l = i;
                        break;
                    }
                }
                if(s.charAt(i) == 'b') {
                    if(s.charAt(i+1) == 'a' || s.charAt(i+1) == 'b') {
                        l = i;
                        break;
                    }
                }
            }
            for (int i = s.length() - 1; i > 0; --i) {
                if(s.charAt(i) == 'a') {
                    if(s.charAt(i-1) == 'a' || s.charAt(i-1) == 'b') {
                        r = i;
                        break;
                    }
                }
                if(s.charAt(i) == 'b') {
                    if(s.charAt(i-1) == 'a' || s.charAt(i-1) == 'b') {
                        r = i;
                        break;
                    }
                }
            }
            if(r > l) return maximumGain(s.substring(l, r+1), x, y);
            return 0;
        }
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