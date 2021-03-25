package com.xinzhe.contest.weekly.season05.weekly231;

/**
 * @author Xin
 * @date 2021/03/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23101 {
    public static void main(String[] args) {
        Leetcode_weekly_23101 lc = new Leetcode_weekly_23101();
        System.out.println(lc.checkOnesSegment("10110000"));
    }
    public boolean checkOnesSegment(String s) {
        if(s.length() < 3) return true;
        String[] split = s.split("0");
        return split.length <= 2;
    }
}
