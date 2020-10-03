package com.xinzhe.contest.weekly.season03.weekly138;

/**
 * @author Xin
 * @date 2020/8/25
 * Title : 1052. 爱生气的书店老板
 * Description : 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *              在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *              书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *              请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * link : https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * Level : Medium
 */

public class Leetcode_weekly_13802 {
    public static void main(String[] args) {
        Leetcode_weekly_13802 lc = new Leetcode_weekly_13802();
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int n = customers.length;
        int res = 0;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(grumpy[i] == 0) count += customers[i];
        }
        int j = 0;
        for(int i=0; i<n; i++) {
            if(j < x) {
                if(grumpy[i]==1){
                    count += customers[i];
                }
                j++;
            } else {
                if(grumpy[i] == 1) count += customers[i];
                if(grumpy[i-x] == 1) count -= customers[i - x];
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
