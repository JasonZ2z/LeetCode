package com.xinzhe.contest.weekly.season05.weekly202;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/8/16
 * Title : 1552. 两球之间的磁力
 * Description : 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 *              Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 *              已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 *              给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * link : https://leetcode-cn.com/problems/magnetic-force-between-two-balls
 * Level : Medium
 * tag : 二分
 */
public class Leetcode_weekly_20203 {
    public static void main(String[] args) {
        Leetcode_weekly_20203 lc = new Leetcode_weekly_20203();
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int l = 1, r = position[n-1];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(position, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] position, int m, int mid) {
        int count = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if(position[i] - pre >= mid) {
                count++;
                pre = position[i];
            }
        }
        return count >= m;
    }

}
