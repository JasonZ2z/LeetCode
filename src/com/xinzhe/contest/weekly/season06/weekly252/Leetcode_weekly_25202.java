package com.xinzhe.contest.weekly.season06.weekly252;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2021/08/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_25202 {
    public static void main(String[] args) {
        Leetcode_weekly_25202 lc = new Leetcode_weekly_25202();
        int[] arr = {5,7,5,10};
        System.out.println(lc.numberOfWeeks(arr));

    }

    public long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        Arrays.sort(milestones);
        long sum = 0L;
        for (int milestone : milestones) {
            sum += milestone;
        }
        if(milestones[n-1] > sum / 2) {
            return (sum - milestones[n-1]) * 2 +1;
        }
        return sum;
    }

}
