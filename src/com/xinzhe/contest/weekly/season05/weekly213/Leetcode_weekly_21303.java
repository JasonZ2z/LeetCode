package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/11/01
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21303 {
    public static void main(String[] args) {
        Leetcode_weekly_21303 lc = new Leetcode_weekly_21303();
        int[] arr = {3,5};
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int sum = 0, tmp = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if(diff <= 0) continue;
            sum += diff; tmp += diff;
            queue.offer(diff);
            if(queue.size() > ladders) tmp -= queue.poll();
            if(sum - tmp > bricks) return i-1;
        }
        return heights.length-1;
    }
}
