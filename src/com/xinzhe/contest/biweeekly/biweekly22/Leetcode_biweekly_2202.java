package com.xinzhe.contest.biweeekly.biweekly22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/4/18 22:16
 * Title : 1386. 安排电影院座位
 * Description : 电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 * link : https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
 * Level : Medium
 * Comment : 22双周赛02
 */
public class Leetcode_biweekly_2202 {
    public static void main(String[] args) {
        int[][] a = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(maxNumberOfFamilies(3, a));
    }
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if(map.containsKey(seat[0])) {
                map.get(seat[0]).add(seat[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(seat[1]);
                map.put(seat[0], set);
            }
        }
        int res = 2*n;
        for (Set<Integer> v : map.values()) {
            int count = 0;
            if(helper(2,5,v)) {
                count++;
                if(helper(6,9,v)) {
                    count++;
                }
            } else {
                if(helper(4,7,v)) {
                    count++;
                } else if(helper(6,9,v)) {
                    count++;
                }
            }
            res -= 2 - count;
        }
        return res;
    }

    private static boolean helper(int l, int r, Set<Integer> v) {
        for (int i = l; i <= r; ++i) {
            if(v.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
