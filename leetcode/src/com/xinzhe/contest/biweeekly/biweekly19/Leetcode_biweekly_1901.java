package com.xinzhe.contest.biweeekly.biweekly19;

/**
 * @Author Xin
 * @create 2020/5/20
 * Title : 1342. 将数字变成 0 的操作次数
 * Description : 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * link : https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * Level : Easy
 * Comment 19双周赛01
 */

public class Leetcode_biweekly_1901 {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            steps++;
        }
        return steps;
    }
}
