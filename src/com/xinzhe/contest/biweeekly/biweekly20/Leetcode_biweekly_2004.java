package com.xinzhe.contest.biweeekly.biweekly20;

/**
 * @author Xin
 * @date 2020/5/18
 * Title : 1359. 有效的快递序列数目
 * Description : 给你 n 笔订单，每笔订单都需要快递服务。请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务 delivery(i) 总是在其收件服务 pickup(i) 之后。
 * 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
 * link : https://leetcode-cn.com/problems/count-all-valid-pickup-and-delivery-options
 * Level : Hard
 * Comment 20双周赛04
 */

public class Leetcode_biweekly_2004 {
    static final int MOD = (int) (1e9 + 7);

    public int countOrders(int n) {
        long last = 1;
        for (int i = 1; i <= n; ++i) {
            int c = i * (2 * i - 1);
            last = last * c % MOD;
        }
        return (int) last;
    }

}
