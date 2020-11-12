package com.xinzhe.sword.chapter08;

/**
 * @author Xin
 * @date 2020/11/12
 * Title : 08.14. 布尔运算
 * Description : 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 * link : https://leetcode-cn.com/problems/boolean-evaluation-lcci
 * Level : Hard
 * tag : 区间dp
 */
public class Interview_0814 {
    public static void main(String[] args) {
        Interview_0814 lc = new Interview_0814();
    }

    //"1^0|0|1" 0
    //"0&0&0&1^1|0" 1
    Integer[][][] dp;
    char[] arr;
    public int countEval(String s, int result) {
        int n = s.length();
        this.arr = s.toCharArray();
        this.dp = new Integer[n][n][2];
        return solve(0, n-1,result);
    }

    private int solve(int i, int j, int result) {
        if(i == j) return dp[i][j][result] = arr[i] - '0' == result ? 1 : 0;
        if(dp[i][j][result] != null) return dp[i][j][result];
        int ans = 0;
        for (int k = i; k < j; k+=2) {
            char op = arr[k + 1];
            //[i, k] op [k+2, j]
            if(helper(0, 0, op) == result) ans += solve(i, k, 0) * solve(k+2, j, 0);
            if(helper(0, 1, op) == result) ans += solve(i, k, 0) * solve(k+2, j, 1);
            if(helper(1, 0, op) == result) ans += solve(i, k, 1) * solve(k+2, j, 0);
            if(helper(1, 1, op) == result) ans += solve(i, k, 1) * solve(k+2, j, 1);
        }
        dp[i][j][result] = ans;
        return ans;
    }

    private int helper(int i, int j, char op) {
        if(op == '|') return i | j;
        else if(op == '&') return i & j;
        else return i ^ j;
    }
}
