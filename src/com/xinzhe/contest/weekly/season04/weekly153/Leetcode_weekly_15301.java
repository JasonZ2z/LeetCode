package com.xinzhe.contest.weekly.season04.weekly153;

import java.util.Arrays;

/**
 * @author Xin
 * @date 2020/7/29
 * Title : 1184. 公交站间的距离
 * Description : 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *              环线上的公交车都可以按顺时针和逆时针的方向行驶。返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * link : https://leetcode-cn.com/problems/distance-between-bus-stops
 * Level : Easy
 */

public class Leetcode_weekly_15301 {

    public static void main(String[] args) {
        Leetcode_weekly_15301 lc = new Leetcode_weekly_15301();
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination) return 0;
        long sum = Arrays.stream(distance).sum();
        if(start > destination) {
            int tmp = destination;
            destination =  start;
            start = tmp;
        }
        long part = 0;
        for(int i=start; i<destination; i++) {
            part += distance[i];
        }
        return (int) Math.min(part, sum - part);
    }

}
