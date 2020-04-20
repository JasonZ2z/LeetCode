package com.xinzhe.order.day10;

/**
 * @Author Xin
 * @create 2020/4/18 14:55
 * Title : LCP 06. 拿硬币
 * Description : 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * link : https://leetcode-cn.com/problems/na-ying-bi/
 * Level : Easy
 * Comment : 2020春季个人赛01
 */
public class Leetcode_single_041801 {
    public int minCount(int[] coins) {
        int n = coins.length;
        if(n == 0) return 0;
        int count = 0;
        for (int coin : coins) {
            count += (coin + 1) >> 1;
        }
        return count;
    }

}
