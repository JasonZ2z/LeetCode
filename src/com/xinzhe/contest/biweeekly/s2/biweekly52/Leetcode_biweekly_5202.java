package com.xinzhe.contest.biweeekly.s2.biweekly52;

/**
 * @author Xin
 * @date 2021/06/12
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_5202 {
    public static void main(String[] args) {
        Leetcode_biweekly_5202 lc = new Leetcode_biweekly_5202();
    }
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] pre = new long[n+1];
        for (int i = 1; i <= n; ++i) {
            pre[i] = chalk[i-1] + pre[i-1];
        }
        k = (int) (k % pre[n]);

        for (int i = 1; i < pre.length; i++) {
            if(k < pre[i]) {
                return i-1;
            }
        }
        return 0;
    }
}