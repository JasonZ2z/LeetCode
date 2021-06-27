package com.xinzhe.contest.weekly.season05.weekly246;

/**
 * @author Xin
 * @date 2021/06/20
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24601 {
    public static void main(String[] args) {
        Leetcode_weekly_24601 lc = new Leetcode_weekly_24601();

    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

}
