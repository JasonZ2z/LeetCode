package com.xinzhe.categories.solutions.slidingwindow.medium;

import java.util.Arrays;

/**
 * @Author Xin
 * @create 2020/6/5
 * Title : 1040. 移动石子直到连续 II
 * Description : 在一个长度无限的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作端点石子。
 * 每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
 * 值得注意的是，如果石子像 stones = [1,2,5] 这样，你将无法移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
 * 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 * 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * link : https://leetcode-cn.com/problems/moving-stones-until-consecutive-ii
 * Level : Medium
 */

public class Leetcode1040 {

    // 4 7 9
    // 789
    // 457 -> 567
    //todo need to review
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int gaps = stones[n - 1] - stones[0] + 1 - n;
        if (gaps == 0) return new int[]{0, 0};
        int m = Math.min(stones[1] - stones[0] - 1, stones[n - 1] - stones[n - 2] - 1);
        int max = gaps - m;
        int min = max;

        int left = 0, right = 0;
        for (; left < n; left++) {
            while (right + 1 < n && stones[right + 1] - stones[left] + 1 - n <= 0) {
                right++;
            }
            int cost = n - (right - left + 1);
            if (right - left + 1 == n - 1 && stones[right] - stones[left] + 1 == n - 1) {
                cost = 2;
            }
            min = Math.min(min, cost);
        }
        return new int[]{min, max};

    }
}
