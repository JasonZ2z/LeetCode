package com.xinzhe.contest.weekly.season05.weekly224;

/**
 * @author Xin
 * @date 2021/01/17
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_22401 {
    public static void main(String[] args) {
        Leetcode_weekly_22401 lc = new Leetcode_weekly_22401();
        int[] arr = {3,5};
    }
    public int countGoodRectangles(int[][] rectangles) {
        int n = 0, cnt = 0;
        for (int[] rectangle : rectangles) {
            int cur = Math.min(rectangle[0], rectangle[1]);
            if(cur > n) {
                n = cur;
                cnt = 1;
            } else if(cur == n) {
                cnt++;
            }
        }
        return cnt;
    }
}
