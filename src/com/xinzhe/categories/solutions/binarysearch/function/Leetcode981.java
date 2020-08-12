package com.xinzhe.categories.solutions.binarysearch.function;

import java.util.*;

/**
 * @author Xin
 * @date 2020/4/10 21:37
 * Title : 981. 基于时间的键值存储
 * Description : 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *      1. set(string key, string value, int timestamp)
 *              存储键 key、值 value，以及给定的时间戳 timestamp。
 *      2. get(string key, int timestamp)
 *              返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 *              如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 *              如果没有值，则返回空字符串（""）。
 * link : https://leetcode-cn.com/problems/time-based-key-value-store
 * Level : Medium
 */

public class Leetcode981 {
    public static void main(String[] args) {
        TimeMap t = new TimeMap();
//        t.set("foo", "bar", 1);
//        t.set("foo1", "bar1", 1);
//        System.out.println(t.get("foo", 1));
//        System.out.println(t.get("foo", 3));
//        t.set("foo2", "bar2", 4);
//        t.set("foo2", "bar3", 5);
//        t.set("foo2", "bar4", 6);
//        System.out.println(t.get("foo", 4));
//        System.out.println(t.get("foo2", 4));
//        System.out.println(t.get("foo2", 5));
//        System.out.println(t.get("foo2", 6));

        t.set("love", "hight", 10);
        t.set("love", "low", 20);
        System.out.println(t.get("love", 5));
        System.out.println(t.get("love", 10));
        System.out.println(t.get("love", 15));
        System.out.println(t.get("love", 20));
        System.out.println(t.get("love", 25));

    }
}

class TimeMap {
    Map<String, List<Value>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Value(value, timestamp));
        } else {
            List<Value> list= new ArrayList<>();
            list.add(new Value(value, timestamp));
            map.put(key, list);
        }
    }


    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Value> keys = map.get(key);
        int left = 0, right = keys.size() -1;
        if(timestamp < keys.get(left).time) return "";
        if(timestamp > keys.get(right).time) timestamp = keys.get(right).time;
        while(left < right){
            int mid = left + ((right -left + 1) >> 1);
            if(keys.get(mid).time > timestamp){
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return keys.get(left).value;
    }

    public String get2(String key, int timestamp) {
        List<Value> list = map.get(key);
        String res = "";
        int i = Collections.binarySearch(list, new Value("", timestamp));
        if(i<0) i= -i-2;
        if(i>=0) res = list.get(i).value;
        return res;
    }
}
class Value implements Comparable<Value>{
    String value;
    int time;
    public Value(String value, int time){
        this.value = value;
        this.time = time;
    }

    @Override
    public int compareTo(Value o) {
        return this.time - o.time;
    }
}