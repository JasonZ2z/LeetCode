package com.xinzhe.contest.weekly.season03.weekly142;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Xin
 * @date 2020/8/19
 * Title : 1094. 拼车
 * Description : 车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 *              这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：
 *              必须接送的乘客数量；乘客的上车地点；以及乘客的下车地点。
 *              这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。
 *              请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 * link : https://leetcode-cn.com/problems/car-pooling
 * Level : Medium
 */

public class Leetcode_weekly_14202 {
    public static void main(String[] args) {
        Leetcode_weekly_14202 lc = new Leetcode_weekly_14202();
    }
    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length;
        if(m == 0) return true;
        int n = trips[0].length;
        if(n == 0) return true;
        if(m == 1 && trips[0][0] <= capacity) return true;

        Map<Integer, List<int[]>> map = new HashMap<>(m);
        for (int[] trip : trips) {
            map.computeIfAbsent(trip[1], a->new ArrayList<>()).add(trip);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);

        int cur = 0;
        for (int i = 0; i <= 1000; ++i) {
            while (!queue.isEmpty() && queue.peek()[2] == i) {
                cur -= queue.poll()[0];
            }
            if(map.containsKey(i)) {
                for (int[] list : map.get(i)) {
                    cur += list[0];
                    if(cur <= capacity) {
                        queue.add(list);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
