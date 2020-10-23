package com.xinzhe.contest.weekly.season03.weekly118;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xin
 * @date 2020/10/23
 * Title : 970. 强整数
 * Description : 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数  i >= 0 且  j >= 0，那么我们认为该整数是一个强整数。
 *              返回值小于或等于  bound  的所有强整数组成的列表。你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * link : https://leetcode-cn.com/problems/powerful-integers
 * Level : Easy
 */

public class Leetcode_weekly_11801 {
    public static void main(String[] args) {
        Leetcode_weekly_11801 lc = new Leetcode_weekly_11801();
        int[][] arr = {{1,3}, {-2,2}};
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                set.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
