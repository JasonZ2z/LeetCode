package com.xinzhe.contest.biweeekly.s1.biweekly28;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/6/13
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_2801 {
    public static void main(String[] args) {

    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] tmp = new int[n];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; ++j) {
                if(prices[j] <= prices[i]) {
                    tmp[i] = prices[i] - prices[j];
                    break;
                }
            }
            if(tmp[i] == -1) tmp[i] = prices[i];

        }
        tmp[n-1] = prices[n-1];
        return tmp;
    }
}
