package com.xinzhe.contest.weekly.season05.weekly238;

/**
 * @author Xin
 * @date 2021/04/25
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23801 {
    public static void main(String[] args) {
        Leetcode_weekly_23801 lc = new Leetcode_weekly_23801();
        System.out.println(Integer.toUnsignedString(34, 6));

    }
    public int sumBase(int n, int k) {
        String s = Integer.toUnsignedString(n, k);
        int res = 0;
        for (char c : s.toCharArray()) {
            res += c - '0';
        }
        return res;
    }
}
