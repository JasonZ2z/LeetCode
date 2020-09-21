package com.xinzhe.contest.weekly.season03.weekly144;

/**
 * @author Xin
 * @date 2020/8/18
 * Title : 1109. 航班预订统计
 * Description : 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *              我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *              请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 * link : https://leetcode-cn.com/problems/corporate-flight-bookings
 * Level : Medium
 */

public class Leetcode_weekly_14402 {
    public static void main(String[] args) {
        Leetcode_weekly_14402 lc = new Leetcode_weekly_14402();
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]-1; i < booking[1]; ++i) {
                res[i] += booking[2];
            }
        }
        return res;
    }
    //todo need to review
    //差分思想
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] freq = new int[n];
        for(int[] b : bookings) {
            int from = b[0], to = b[1], k = b[2];
            freq[from - 1] += k;
            if(to < n) freq[to] -= k;
        }
        for(int i=1; i<n; i++) {
            freq[i] += freq[i-1];
        }
        return freq;
    }
}
