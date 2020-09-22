package com.xinzhe.contest.weekly.season03.weekly127;

/**
 * @author Xin
 * @date 2020/9/22
 * Title : 1006. 笨阶乘
 * Description : 我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *              例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：
 *              我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 * link : https://leetcode-cn.com/problems/clumsy-factorial
 * Level : Medium
 */

public class Leetcode_weekly_12702 {
    public static void main(String[] args) {
        Leetcode_weekly_12702 lc = new Leetcode_weekly_12702();
        System.out.println(lc.clumsy(10));
    }
    public int clumsy(int n) {
        if(n <4) return helper(n);
        int ans = n * (n - 1) / (n-2) + n - 3;
        for(n = n-4; n>=4; n-=4) {
            ans -= n * (n - 1) / (n-2) - n  + 3;
        }
        return ans - helper(n);
    }
    private int helper(int x) {
        if(x == 1) return 1;
        if(x == 2) return 2;
        if(x == 3) return 3 * 2;
        return 0;
    }
}
