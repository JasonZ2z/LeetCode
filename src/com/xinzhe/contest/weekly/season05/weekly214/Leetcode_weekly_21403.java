package com.xinzhe.contest.weekly.season05.weekly214;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/11/08
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21403 {
    public static void main(String[] args) {
        Leetcode_weekly_21403 lc = new Leetcode_weekly_21403();
        int[] arr = {497978859,167261111,483575207,591815159};
        //System.out.println(lc.maxProfit(arr, 836556809));
        System.out.println(lc.maxProfit(arr, 836556809));
    }
    static final int MOD = (int)1e9 +7;

    public int maxProfit(int[] inventory, int orders) {
        int n = inventory.length;
        long ans = 0;
        if(n ==1) {
            ans +=(long) (inventory[0] + inventory[0] - orders + 1) * orders / 2;
            ans %= MOD;
            return (int) ans;
        }
        Arrays.sort(inventory);
        int cnt = 0;
        int x = inventory[n - 1];
        for(int i = n-2; i >= 0; --i) {
            cnt += x - inventory[i];
            if(cnt > orders) {
                int y = cnt - orders;

            }
        }
        return (int) ans;
    }
}
