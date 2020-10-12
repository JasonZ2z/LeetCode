package com.xinzhe.contest.weekly.season05.weekly210;

import java.util.HashSet;

/**
 * @author Xin
 * @date 2020/10/11
 * Title : 1615. 最大网络秩
 * Description : n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *              两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *              整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 * link : https://leetcode-cn.com/problems/maximal-network-rank
 * Level : Medium
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
