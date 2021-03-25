package com.xinzhe.contest.weekly.season05.weekly233;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23303 {
    public static void main(String[] args) {
        Leetcode_weekly_23303 lc = new Leetcode_weekly_23303();
       // System.out.println(lc.maxValue(4, 2, 6));
        System.out.println(lc.maxValue(3, 0, 815094800));

    }
    public int maxValue(int n, int index, int maxSum) {
        if(n == 1) return maxSum;
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if(check(mid, mid - index, mid - (n - 1 - index), maxSum)) {
               l = mid;
            } else{
              r = mid - 1;
            }
        }
        return l;
    }
    public long sum(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    private boolean check(int x, int l, int r, int maxSum) {

        return sum(Math.max(l, 1), x) + (Math.max(l, 1) - l) + sum(Math.max(r, 1), x) + (Math.max(r, 1) - r) - x <= maxSum;
    }
}
