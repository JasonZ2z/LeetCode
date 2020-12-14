package com.xinzhe.contest.biweeekly.biweekly41;

import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/12/12
 * Title : 1686. 石子游戏 VI
 * Description : Alice 和Bob 轮流玩一个游戏，Alice 先手。
 *              一堆石子里总共有n个石子，轮到某个玩家时，他可以 移出一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准。
 *              给你两个长度为 n的整数数组aliceValues 和bobValues。aliceValues[i] 和bobValues[i]分别表示 Alice 和 Bob 认为第i个石子的价值。
 *              所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略进行游戏。
 *              请你推断游戏的结果，用如下的方式表示：如果 Alice 赢，返回1。如果 Bob 赢，返回-1。如果游戏平局，返回0。
 * link : https://leetcode-cn.com/problems/stone-game-vi
 * Level : Medium
 */
//todo need to review
public class Leetcode_biweekly_4103 {
    public static void main(String[] args) {
        Leetcode_biweekly_4103 lc = new Leetcode_biweekly_4103();
        int[] a1 = {2,9,1,1,1,3,5,8,8,6,8,6,2,4};
        int[] a2 = {1,9,7,8,3,4,2,7,8,10,1,7,10,4};
        System.out.println(lc.stoneGameVI(a1, a2));
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < aliceValues.length; ++i) {
            queue.offer(new int[]{i, aliceValues[i] + bobValues[i]});
        }
        boolean flag = true;
        int a = 0, b = 0;
        while (!queue.isEmpty()) {
            if(flag) {
                a += aliceValues[queue.poll()[0]];
                flag = false;
            } else {
                b += bobValues[queue.poll()[0]];
                flag = true;
            }
        }
        return Integer.compare(a, b);
    }
}