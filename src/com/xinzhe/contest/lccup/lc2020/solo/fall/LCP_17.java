package com.xinzhe.contest.lccup.lc2020.solo.fall;

/**
 * @author Xin
 * @date 2020/9/12
 * Title : LCP 17. 速算机器人
 * Description : 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 *              "A" 运算：使 x = 2 * x + y；"B" 运算：使 y = 2 * y + x。
 *              在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 * link : https://leetcode-cn.com/problems/nGK0Fy
 * Level : Easy
 */
public class LCP_17 {
    public int calculate(String s) {
        int n = s.length();
        if(n == 0) return 1;
        char[] arr = s.toCharArray();
        int x = 1, y=0;
        for (char c : arr) {
            if(c == 'A') {
                x = 2*x +y;
            } else {
                y = 2 *y + x;
            }
        }
        return x + y;
    }
}
