package com.xinzhe.contest.weekly.season03.weekly121;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Xin
 * @date 2020/9/28
 * Title : 981. 基于时间的键值存储
 * Description : 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *              1. set(string key, string value, int timestamp) 存储键 key、值 value，以及给定的时间戳 timestamp。
 *              2. get(string key, int timestamp)  返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 *              如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。 如果没有值，则返回空字符串（""）。
 * link : https://leetcode-cn.com/problems/time-based-key-value-store
 * Level : Medium
 */

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, a -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            if(entry != null) {
                return entry.getValue();
            }
        }
        return "";
    }
}
