package com.xinzhe.contest.weekly.season05.weekly203;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/8/16
 * Title :
 * Description :
 * link : 
 * Level :
 */
public class Leetcode_weekly_20302 {
    public static void main(String[] args) {
        Leetcode_weekly_20302 lc = new Leetcode_weekly_20302();
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int pile : piles) {
            queue.offer(pile);
        }
        while(!queue.isEmpty()) {
            queue.removeLast();
            res += queue.removeLast();
            queue.removeFirst();
        }

        return res;
    }
}
