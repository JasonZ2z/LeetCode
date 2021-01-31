package com.xinzhe.contest.weekly.season05.weekly226;

/**
 * @author Xin
 * @date 2021/01/31
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22603 {
    public static void main(String[] args) {
        Leetcode_weekly_22603 lc = new Leetcode_weekly_22603();
    }
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] res = new boolean[n];

        int candieLen =  candiesCount.length;
        long[] pre = new long[candieLen + 1];
        for (int i = 1; i <= candieLen; i++) {
            pre[i] = pre[i-1] + candiesCount[i-1];
        }

        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int max = queries[i][2];
            if(day == 0) {
                res[i] = max > pre[type];
            }
            res[i] = (long) max * (day + 1) > pre[type] && pre[type + 1] > day;
        }
        return res;

    }
}
