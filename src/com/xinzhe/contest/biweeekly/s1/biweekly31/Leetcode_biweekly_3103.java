package com.xinzhe.contest.biweeekly.s1.biweekly31;

/**
 * @author Xin
 * @date 2020/7/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_3103 {
    public static void main(String[] args) {
        Leetcode_biweekly_3103 lc = new Leetcode_biweekly_3103();
    }

    public int numSplits(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] count = new int[26];

        for (char c : arr) {
            count[c - 'a']++;
        }

        int[] dp = new int[26];
        int i = 0;
        int res = 0;
        while (i<n){
            dp[arr[i] - 'a']++;
            if(helper(dp, count)) {
                res++;
            }
            i++;
        }
        return res;
    }

    private boolean helper(int[] dp, int[] count) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 26; i++) {
            if(dp[i] > 0) {
                a++;
            }
            if(count[i] - dp[i] > 0) {
                b++;
            }
        }
        return a == b;
    }
}
