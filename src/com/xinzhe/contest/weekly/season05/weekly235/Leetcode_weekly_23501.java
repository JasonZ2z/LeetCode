package com.xinzhe.contest.weekly.season05.weekly235;

/**
 * @author Xin
 * @date 2021/03/28
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23501 {
    public static void main(String[] args) {
        Leetcode_weekly_23501 lc = new Leetcode_weekly_23501();

    }

    public int arraySign(int[] nums) {
        int x = 0;
        for (int num : nums) {
            if(num == 0) return 0;
            if(num < 0) x++;
        }
        return x % 2 == 0 ? 1 : -1;
    }
}
