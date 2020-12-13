package com.xinzhe.contest.weekly.season05.weekly219;

/**
 * @author Xin
 * @date 2020/12/13
 * Title :
 * Description :
 * link :
 * Level : Medium
 */
public class Leetcode_weekly_21902 {
    public static void main(String[] args) {
        Leetcode_weekly_21902 lc = new Leetcode_weekly_21902();
        int[] arr = {3,5};
    }
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            int x = c - '0';
            max = Math.max(x , max);
        }
        return max;
    }
}
