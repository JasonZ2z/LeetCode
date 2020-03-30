package com.xinzhe.categories.solutions.backtrack;

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

public class Generate_Parentheses {
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n==0) return list;
        dfs("", 0, 0, n, list);
        return list;
    }

    private static void dfs(String str, int left, int right, int n, List<String> list) {
        if(left == n && right == n) {
            list.add(str);
            return;
        }
        if(left < right) return;
        if(left < n){
            dfs(str+"(",left+1, right, n, list);
        }
        if(right < n){
            dfs(str+")", left, right+1, n, list);
        }
    }
}
