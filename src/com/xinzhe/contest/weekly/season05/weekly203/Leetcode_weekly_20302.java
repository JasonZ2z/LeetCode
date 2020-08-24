package com.xinzhe.contest.weekly.season05.weekly203;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/8/23
 * Title : 1561. 你可以获得的最大硬币数目
 * Description : 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 *              Alice 将会取走硬币数量最多的那一堆。你将会取走硬币数量第二多的那一堆。
 *              Bob 将会取走最后一堆。重复这个过程，直到没有更多硬币。
 *              给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。返回你可以获得的最大硬币数目。
 * link :  https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get
 * Level : Medium
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
