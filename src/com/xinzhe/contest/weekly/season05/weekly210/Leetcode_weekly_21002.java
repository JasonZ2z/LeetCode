package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/10/11
 * Title :
 * Description :
 * link :
 * Level : Easy
 */
public class Leetcode_weekly_21002 {
    public static void main(String[] args) {
        Leetcode_weekly_21002 lc = new Leetcode_weekly_21002();
        int[] arr = {3,5};
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer>[] set = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            set[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            set[road[0]].add(road[1]);
            set[road[1]].add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n; ++j) {
                if(set[i].contains(j)) {
                    max = Math.max(max, set[i].size() + set[j].size() -  1);
                } else {
                    max = Math.max(max, set[i].size() + set[j].size());
                }
            }
        }
        return max;
    }


}
