package com.xinzhe.contest.weekly.season05.weekly237;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/04/18
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23702 {
    public static void main(String[] args) {
        Leetcode_weekly_23702 lc = new Leetcode_weekly_23702();

    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if(coins >= cost) {
                count++;
                coins -= cost;
            } else{
                break;
            }
        }
        return count;
    }
}
