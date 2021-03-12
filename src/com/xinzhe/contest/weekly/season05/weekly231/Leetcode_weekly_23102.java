package com.xinzhe.contest.weekly.season05.weekly231;

/**
 * @author Xin
 * @date 2021/03/07
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_23102 {
    public static void main(String[] args) {
        Leetcode_weekly_23102 lc = new Leetcode_weekly_23102();
    }
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0L;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs(sum - goal);
        long count = diff / limit;
        if(diff % limit == 0) {
            return (int)count;
        } else {
            return (int)(count + 1);
        }
    }
}
