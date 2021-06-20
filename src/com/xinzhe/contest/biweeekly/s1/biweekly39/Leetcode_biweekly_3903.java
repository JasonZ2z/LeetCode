package com.xinzhe.contest.biweeekly.s1.biweekly39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Xin
 * @date 2020/11/14
 * Title : 1654. 到家的最少跳跃次数
 * Description : 有一只跳蚤的家在数轴上的位置x处。请你帮助它从位置0出发，到达它的家。跳蚤跳跃的规则如下：
 *              它可以 往前 跳恰好 a个位置（即往右跳）。
 *              它可以 往后跳恰好 b个位置（即往左跳）。
 *              它不能 连续 往后跳 2 次。
 *              它不能跳到任何forbidden数组中的位置。
 *              跳蚤可以往前跳 超过它的家的位置，但是它 不能跳到负整数的位置。
 *              给你一个整数数组forbidden，其中forbidden[i]是跳蚤不能跳到的位置，同时给你整数a，b和x，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x的可行方案，请你返回 -1 。
 * link : https://leetcode-cn.com/problems/minimum-jumps-to-reach-home
 * Level : Medium
 */

//todo need to review
public class Leetcode_biweekly_3903 {
    public static void main(String[] args) {
        Leetcode_biweekly_3903 lc = new Leetcode_biweekly_3903();
    }

    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        int[] dp = new int[4001];
        Arrays.fill(dp, (int)1e7);
        Set<Integer> set = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, false));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.index < 0 || cur.index > 4000 || cur.step >= dp[cur.index] || set.contains(cur.index)) continue;
            dp[cur.index] = cur.step;
            if(cur.back) {
                queue.offer(new Node(cur.index - b, cur.step + 1, false));
            }
            queue.offer(new Node(cur.index + a, cur.step + 1, true));
        }
        return dp[x] == (int)1e7 ? -1 : dp[x];
    }

    class Node {
        int index;
        int step;
        boolean back;

        public Node(int index, int step, boolean back) {
            this.index = index;
            this.step = step;
            this.back = back;
        }
    }
}
