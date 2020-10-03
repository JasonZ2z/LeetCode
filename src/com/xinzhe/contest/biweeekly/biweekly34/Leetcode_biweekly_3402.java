package com.xinzhe.contest.biweeekly.biweekly34;

/**
 * @author Xin
 * @date 2020/9/5
 * Title : 1573. 分割字符串的方案数
 * Description : 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 *              请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 *              由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 * link : https://leetcode-cn.com/problems/number-of-ways-to-split-a-string
 * Level : Medium
 */
public class Leetcode_biweekly_3402 {
    public static void main(String[] args) {
        Leetcode_biweekly_3402 lc = new Leetcode_biweekly_3402();
    }

    static final int MOD = (int)1e9 + 7;
    public int numWays(String s) {
        int n = s.length();

        int c0 = 0;
        char[] arr = s.toCharArray();
        for(char c : arr) {
            if(c == '1') c0++;
        }

        if(c0 == 0) return (int)(combination(n-1, 2) % MOD);
        if(c0 % 3 != 0) return 0;
        int c = c0 /3;

        int i=0, cl = 0;
        while(cl !=  c) {
            if(arr[i++] == '1') cl++;
        }
        int p = i;
        while(arr[i] != '1') {
            i++;
        }
        long k = i - p + 1;

        int j=n-1, cr = 0;
        while(cr !=  c) {
            if(arr[j--] == '1') cr++;
        }

        int q = j;
        while(arr[j] != '1') {
            j--;
        }

        long k2 = q- j + 1;

        long res = k*k2;
        res %= MOD;

        return (int)res;

    }

    private static long combination(int n, int k) {
        long a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return a/b;
    }

}
