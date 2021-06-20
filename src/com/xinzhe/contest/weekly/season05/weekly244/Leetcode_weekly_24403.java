package com.xinzhe.contest.weekly.season05.weekly244;

/**
 * @author Xin
 * @date 2021/06/06
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_24403 {
    public static void main(String[] args) {
        Leetcode_weekly_24403 lc = new Leetcode_weekly_24403();
        String s = "01001001101";
        String s1 = "111000";
        String s2 = "10001100101000000";
        System.out.println(lc.minFlips(s));
        System.out.println(lc.minFlips(s1));
        System.out.println(lc.minFlips(s2));
    }

    public int minFlips(String s) {
        s = s + s;
        int min = 0, count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) - '0' != i % 2) {
                count++;
            }
        }
        min = Math.min(count, s.length() / 2 - count);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) - '0' != i % 2) {
                count--;
            }
            if (s.charAt(i + s.length() / 2) - '0' != (i + s.length() / 2) % 2) {
                count++;
            }
            min = Math.min(min, Math.min(count, s.length() / 2 - count));
        }
        return min;
    }
}
