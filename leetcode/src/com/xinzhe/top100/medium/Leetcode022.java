package com.xinzhe.top100.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Xin
 * @create 2020/1/4 18:55
 * Title : 22. 括号生成
 * Description : 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * link : https://leetcode-cn.com/problems/generate-parentheses/
 * Level : Medium
 */
public class Leetcode022 {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }
    private static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        traceback("", 0, 0, n);
        return result;
    }

    private static void traceback(String track, int left, int right, int n) {
        if(left == n && right == n){
            result.add(track);
            return;
        }
        if(left < right) return;
        if(left < n){
            traceback(track+"(", left+1, right, n);
        }
        if(right < n){
            traceback(track+")", left, right+1, n);
        }
    }
}
