package com.xinzhe.contest.weekly.season05.weekly214;

/**
 * @author Xin
 * @date 2020/11/08
 * Title :
 * Description :
 * link :
 * Level :
 */
public class Leetcode_weekly_21401 {
    public static void main(String[] args) {
        Leetcode_weekly_21401 lc = new Leetcode_weekly_21401();
        int[] arr = {3,5};
    }
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; ++i) {
            if(i % 2 == 0) res[i] = res[i / 2];
            else {
                res[i] = res[i/2] + res[i/2 + 1];
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
