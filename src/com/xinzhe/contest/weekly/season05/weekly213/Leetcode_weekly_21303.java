package com.xinzhe.contest.weekly.season05.weekly213;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/11/01
 * Title : 1642. 可以到达的最远建筑
 * Description : 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 *          当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 *          如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * link : https://leetcode-cn.com/problems/furthest-building-you-can-reach
 * Level : Medium
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
