package com.xinzhe.contest.biweeekly.s2.biweekly63;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/10/16
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_biweekly_6301 {
    public static void main(String[] args) {
        Leetcode_biweekly_6301 lc = new Leetcode_biweekly_6301();

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

}