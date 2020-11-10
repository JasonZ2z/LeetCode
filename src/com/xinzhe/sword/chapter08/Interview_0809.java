package com.xinzhe.sword.chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/7/14
 * Title : 08.09. 括号
 * Description : 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。说明：解集不能包含重复的子集。
 * link : https://leetcode-cn.com/problems/bracket-lcci/
 * Level : Medium
 */
public class Interview_0809 {
    public static void main(String[] args) {
        Interview_0809 lc = new Interview_0809();
        System.out.println(lc.generateParenthesis(3));
    }
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String cur) {
        if(left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if(left > right || left < 0) return;
        dfs(left - 1, right, cur + "(");
        dfs(left, right - 1, cur + ")");
    }
}
