package com.xinzhe.contest.nowcoder.s1.s109;

/**
 * @author Xin
 * @date 2020/8/7
 * Title : 牛牛的字符反转
 * Description :  只能实现区间反转操作，现在牛牛有一个长度为n的字符串，他想进行循环右移k位的操作，你能告诉牛牛，他最少对这个字符串进行几次区间反转操作能实现循环右移k位呢。
 *              反转操作指字符串某一区间\left[ L,R \right][L,R]内的字符反转，
 *              例如“123456”，区间[3,5]进行反转字符串变为“125436”。假设字符串每一位都不同。给定一个字符串长度n和循环右移次数k，求最少反转次数。
 * link : https://ac.nowcoder.com/acm/contest/6947/A
 * Level : Easy
 */
public class nowcoder_0901 {
    /**
     *
     * @param n int整型 字符串长度n
     * @param k int整型 循环右移次数k
     * @return int整型
     */
    public int solve (int n, int k) {
        // write code here
        k = k % n;
        if(k == 0 || n == 1) return 0;
        if(n == 2)return 1;
        int left = k, right = n - k;
        if(left == 1 || right == 1 || left == 2 || right == 2) return 2;
        return 3;
    }
}
