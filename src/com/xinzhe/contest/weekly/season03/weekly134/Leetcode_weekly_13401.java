package com.xinzhe.contest.weekly.season03.weekly134;

import java.util.Arrays;

/**
 * @author Xin
 * @date 20209/10
 * Title : 1033. 移动石子直到连续
 * Description : 三枚石子放置在数轴上，位置分别为 a，b，c。
 *              每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 *              当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 *              要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 * link : https://leetcode-cn.com/problems/moving-stones-until-consecutive
 * Level : Easy
 */

public class Leetcode_weekly_13401 {
    public static void main(String[] args) {
        Leetcode_weekly_13401 lc = new Leetcode_weekly_13401();
    }

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int g1 = arr[1] - arr[0];
        int g2 = arr[2] - arr[1];
        if(g1 == 1 && g2 == 1) return new int[]{0,0};
        else if(g1 == 1 || g2 == 1) return new int[]{1, g1 + g2 - 2};
        else if(g1 == 2 || g2 == 2) return new int[]{1, g1 + g2 - 2};
        else return new int[]{2, g1 + g2 -2};
    }
}
