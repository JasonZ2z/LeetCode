package com.xinzhe.contest.weekly.season04.weekly196;

/**
 * @Author Xin
 * @create 2020/7/5
 * Title :
 * Description :
 * link :
 * Level : Medium
 * Comment 196周赛02
 */
public class Leetcode_weekly_19602 {
    public static void main(String[] args) {
        Leetcode_weekly_19602 lc = new Leetcode_weekly_19602();
    }
    public int getLastMoment(int n, int[] left, int[] right) {
        int res =  0;
        for (int value : left) {
            res = Math.max(res, value);
        }
        for (int value : right) {
            res = Math.max(res, n - value);
        }
        return res;
    }
}
