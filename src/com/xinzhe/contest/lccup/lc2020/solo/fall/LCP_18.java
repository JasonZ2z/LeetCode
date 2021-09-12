package com.xinzhe.contest.lccup.lc2020.solo.fall;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/9/12
 * Title : LCP 18. 早餐组合
 * Description : 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。
 *              请返回小扣共有多少种购买方案。注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * link : https://leetcode-cn.com/problems/2vYnGI
 * Level : Easy
 */
public class LCP_18 {
    static final int MOD = (int)1e9 + 7;
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < staple.length; i++) {
            map.put(staple[i] , i + 1);
        }
        long c = 0;
        for (int drink : drinks) {
            if(x > drink) {
                Integer key = map.floorKey(x - drink);
                if(key == null) continue;
                c += map.get(key);
            }
        }
        return (int)(c % MOD);
    }
}
