package com.xinzhe.contest.weekly.season04.weekly182;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Xin
 * @create 2020/5/5
 * Title : 1396. 设计地铁系统
 * Description : 请你实现一个类 UndergroundSystem ，它支持以下 3 种方法：
 * 你可以假设所有对 checkIn 和 checkOut 的调用都是符合逻辑的。也就是说，如果一个顾客在 t1 时刻到达某个地铁站，那么他离开的时间 t2 一定满足 t2 > t1 。所有的事件都按时间顺序给出。
 * link : https://leetcode-cn.com/problems/design-underground-system
 * Level : Medium
 */
public class UndergroundSystem {

    Map<String, Station> stations;
    public UndergroundSystem() {
        stations = new HashMap<>();
    }

    /**
     *1. checkIn(int id, string stationName, int t)
     * 编号为 id 的乘客在 t 时刻进入地铁站 stationName 。
     * 个乘客在同一时间只能在一个地铁站进入或者离开。
     */
    public void checkIn(int id, String stationName, int t) {
        Station station = stations.getOrDefault(stationName, new Station());
        station.in.put(id, t);
        stations.put(stationName, station);
    }

    /**
     * 2. checkOut(int id, string stationName, int t)
     * 编号为 id 的乘客在 t 时刻离开地铁站 stationName 。
     */
    public void checkOut(int id, String stationName, int t) {
        Station station = stations.getOrDefault(stationName, new Station());
        station.out.put(id, t);
        stations.put(stationName, station);
    }

    /**
     * 3. getAverageTime(string startStation, string endStation) 
     * 返回从地铁站 startStation 到地铁站 endStation 的平均花费时间。
     * 平均时间计算的行程包括当前为止所有从 startStation 直接到达 endStation 的行程。
     * 调用 getAverageTime 时，询问的路线至少包含一趟行程。
     */
    public double getAverageTime(String startStation, String endStation) {
        Station in = stations.get(startStation);
        Station out = stations.get(endStation);
        Set<Integer> ids = in.in.keySet();
        int count = 0;
        float sum = 0;
        for (Integer id : ids) {
            if(out.out.containsKey(id)) {
                sum += out.out.get(id) - in.in.get(id);
                count++;
            }
        }
        return sum/count;
    }

    class Station {
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
    }
}
