package com.xinzhe.contest.weekly.season05.weekly217;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/29
 * Title : 1672. 最富有客户的资产总量
 * Description : 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 *              客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 * link : https://leetcode-cn.com/problems/richest-customer-wealth
 * Level : Easy
 */
public class Leetcode_weekly_21701 {
    public static void main(String[] args) {
        Leetcode_weekly_21701 lc = new Leetcode_weekly_21701();
        int[] arr = {3,5};
    }
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            max = Math.max(Arrays.stream(account).sum(), max);
        }
        return max;
    }
}
