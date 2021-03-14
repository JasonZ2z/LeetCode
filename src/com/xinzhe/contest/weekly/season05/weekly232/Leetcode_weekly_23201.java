package com.xinzhe.contest.weekly.season05.weekly232;

/**
 * @author Xin
 * @date 2021/03/14
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23201 {
    public static void main(String[] args) {
        Leetcode_weekly_23201 lc = new Leetcode_weekly_23201();
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(lc.areAlmostEqual(s1, s2));
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int m = s1.length();
        int count = 0;
        char a = ' ', b = ' ';
        for (int i = 0; i < m; ++i) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 2) return false;
                if(count == 1) {
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                }
                if(count == 2) {
                    if (a != s2.charAt(i) || b != s1.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return count != 1;
    }
}
