package com.xinzhe.contest.weekly.season06.weekly252;

/**
 * @author Xin
 * @date 2021/08/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25203 {
    public static void main(String[] args) {
        Leetcode_weekly_25203 lc = new Leetcode_weekly_25203();

    }
    public long minimumPerimeter(long neededApples) {
        long n = 1L;
        while (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
            n++;
        }
        return n*8;
    }
}