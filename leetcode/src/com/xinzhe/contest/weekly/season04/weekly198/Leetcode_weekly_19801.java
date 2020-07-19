package com.xinzhe.contest.weekly.season04.weekly198;

/**
 * @Author Xin
 * @create 2020/7/19
 * Title :
 * Description :
 * link :
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
