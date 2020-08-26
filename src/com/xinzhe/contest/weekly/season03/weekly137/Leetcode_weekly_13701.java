package com.xinzhe.contest.weekly.season03.weekly137;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/8/26
 * Title : 1046. 最后一块石头的重量
 * Description : 有一堆石头，每块石头的重量都是正整数。
 *              每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *              如果 x == y，那么两块石头都会被完全粉碎;如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *              最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * link : https://leetcode-cn.com/problems/last-stone-weight
 * Level : Easy
 */

public class Leetcode_weekly_13701 {
    public static void main(String[] args) {
        Leetcode_weekly_13701 lc = new Leetcode_weekly_13701();
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for (int stone : stones) queue.offer(stone);
        while(queue.size() > 1){
            int y = queue.poll();
            int x = queue.poll();
            if(y != x) queue.offer(y - x);
        }
        if(queue.isEmpty()) return 0;
        return queue.poll();
    }
}
