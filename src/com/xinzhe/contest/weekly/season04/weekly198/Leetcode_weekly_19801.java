package com.xinzhe.contest.weekly.season04.weekly198;

/**
 * @Author Xin
 * @create 2020/7/19
 * Title : 1518. 换酒问题
 * Description : 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *              如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。请你计算 最多 能喝到多少瓶酒。
 * link : https://leetcode-cn.com/problems/water-bottles
 * Level : Easy
 */
public class Leetcode_weekly_19801 {
    public static void main(String[] args) {
        Leetcode_weekly_19801 lc = new Leetcode_weekly_19801();
        System.out.println(lc.numWaterBottles(15,4));
    }
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles == numExchange) return numBottles +1;
        if(numExchange > numBottles) return numBottles;

        int count = numBottles;
        while (numBottles >= numExchange) {

            int tmp = numBottles / numExchange;
            int va = numBottles % numExchange;
            numBottles = tmp + va ;
            count += tmp;

        }
        return count;
    }
}
