package com.xinzhe.contest.weekly.season06.weekly266;

/**
 * @author Xin
 * @date 2021/11/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_26603 {
    public static void main(String[] args) {
        Leetcode_weekly_26603 lc = new Leetcode_weekly_26603();

    }

    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1 , r = 100000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(check(mid, n, quantities)){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid, int n, int[] quantities) {
        int sum = 0;
        for (int q : quantities) {
            sum += (q + mid - 1) / mid;
        }
        return sum <= n;
    }
}
