package com.xinzhe.categories.dp.knapsack;

import java.util.PriorityQueue;

/**
 * @Author Xin
 * @create 2020/3/20 19:13
 * Title : 1046. 最后一块石头的重量
 * Description : 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * link : https://leetcode-cn.com/problems/last-stone-weight/
 * Level : Easy
 */
public class Leetcode1046 {

    //大顶堆
    //PriorityQueue 默认是小顶堆
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> (o2 - o1));
        for (int stone : stones) {
            queue.add(stone);
        }
        Integer head1;
        while ((head1 = queue.poll()) != null){
            Integer head2 = queue.poll();
            if(head2 == null) {
                return head1;
            } else {
                Integer tmp = Math.abs(head1 - head2);
                queue.add(tmp);
            }
        }
        return 0;
    }
}
