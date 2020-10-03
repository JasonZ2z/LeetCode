package com.xinzhe.contest.weekly.season03.weekly123;

/**
 * @author Xin
 * @date 2020/9/24
 * Title : 991. 坏了的计算器
 * Description : 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *              双倍（Double）：将显示屏上的数字乘 2；递减（Decrement）：将显示屏上的数字减 1 。
 *              最初，计算器显示数字 X。返回显示数字 Y 所需的最小操作数。
 * link : https://leetcode-cn.com/problems/broken-calculator
 * Level : Medium
 */

public class Leetcode_weekly_12303 {
    public static void main(String[] args) {
        Leetcode_weekly_12303 lc = new Leetcode_weekly_12303();
        System.out.println(lc.brokenCalc(3, 10));
    }
    public int brokenCalc(int x, int y) {
        if(y <= x) return x - y;
        int ans = 0;
        if(y % 2 == 1) {
            y++;
            ans++;
        }
        return ans + brokenCalc(x, y/2) + 1;
    }
}
