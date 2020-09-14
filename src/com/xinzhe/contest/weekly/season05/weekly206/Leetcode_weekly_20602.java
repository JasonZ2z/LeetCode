package com.xinzhe.contest.weekly.season05.weekly206;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/9/13
 * Title : 1583. 统计不开心的朋友
 * Description : 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 *              对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 *              所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 *              但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 *              x 与 u 的亲近程度胜过 x 与 y，且 u 与 x 的亲近程度胜过 u 与 v返回 不开心的朋友的数目 。
 * link : https://leetcode-cn.com/problems/count-unhappy-friends
 * Level : Medium
 */
public class Leetcode_weekly_20602 {
    public static void main(String[] args) {
        Leetcode_weekly_20602 lc = new Leetcode_weekly_20602();
        int[][] arr = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] test = {{1,3}, {0,2}};
        System.out.println(lc.unhappyFriends(4, arr, test));
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        int count = 0;
        for (int[] pair : pairs) {
            int from = pair[0];
            int to = pair[1];

            count += getCount(preferences, map, from, to) ? 1 : 0;
            count += getCount(preferences, map, to, from) ?  1 : 0;
        }
        return count;
    }

    private boolean getCount(int[][] preferences, Map<Integer, Integer> map, int from, int to) {
        for (int u : preferences[from]) {
            if(u != to) {
                int v = map.get(u);
                for (int x : preferences[u]) {
                    if(x == from) {
                        return true;
                    }else if( x == v){
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return false;
    }
}
