package com.xinzhe.difficulty.medium.strings;

import java.util.ArrayList;
import java.util.List;

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
