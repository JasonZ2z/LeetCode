package com.xinzhe.contest.weekly.season06.weekly267;

/**
 * @author Xin
 * @date 2021/11/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26701 {
    public static void main(String[] args) {
        Leetcode_weekly_26701 lc = new Leetcode_weekly_26701();
        int[] arr = {84,49,5,24,70,77,87,8};

        // 5 * 8 + 3 * 7 + 16 * 6 = 40 + 21 + 96
        System.out.println(lc.timeRequiredToBuy(arr, 3));

    }
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int val = tickets[k];
        int[] pre = new int[100];
        int[] post = new int[100];

        for (int i = 0; i < tickets.length; i++) {
            if(tickets[i] <= val && i < k) pre[tickets[i]]++;
            if(tickets[i] < val && i > k) post[tickets[i]]++;
        }
        int res = 0, left = k , right = n - k;
        for (int i = 0; i < val; ++i) {
            left -= pre[i];
            right -= post[i];
            res += left + right;
        }
        return res + pre[val];
    }
}
