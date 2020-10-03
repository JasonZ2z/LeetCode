package com.xinzhe.contest.weekly.season04.weekly171;

/**
 * @author Xin
 * @date 2020/5/25
 * Title : 1318. 或运算的最小翻转次数
 * Description : 给你三个正整数 a、b 和 c。
 *              你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 *              「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * link : https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 * Level : Medium
 * Comment 171周赛02
 */

public class Leetcode_weekly_17102 {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 31; ++i) {
            int nc = (c >> i) & 1;
            int na = (a >> i) & 1;
            int nb = (b >> i) & 1;
            if (nc > 0) {
                if (na == 0 && nb == 0) res++;
            } else {
                res += na + nb;
            }
        }
        return res;
    }


}
