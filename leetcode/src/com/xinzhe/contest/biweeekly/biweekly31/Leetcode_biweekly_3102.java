package com.xinzhe.contest.biweeekly.biweekly31;

/**
 * @Author Xin
 * @create 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3102 {
    public static void main(String[] args) {
        Leetcode_biweekly_3102 lc = new Leetcode_biweekly_3102();
        int[] arr = {1};
        System.out.println(lc.numOfSubarrays(arr));
    }
        // 奇数 + 奇数 = 偶数
        // 奇数 + 偶数 = 奇数
    static final int MOD = (int) 1e9 + 7;
    public int numOfSubarrays(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; ++i) {
            dp[i+1] = dp[i] + arr[i];
            if((dp[i + 1] & 1) == 1) c1++;
            else c2++;
        }
        for (int i = 0; i < n; ++i) {
            if((dp[i] & 1) == 1) {
                c1--;
                sum = (sum +  c2) % MOD;
            } else {
                c2--;
                sum = (sum +  c1) % MOD;
            }
        }
        return (int) sum % MOD;
    }

}
