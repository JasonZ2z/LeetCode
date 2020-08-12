package com.xinzhe.categories.structure.design.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    //LinkedHashMap
    //LinkedHashMap的有序可以按两种顺序排列，一种是按照插入的顺序，一种是按照读取的顺序
    //LinkedHashMap 的构造函数, accessOrder(默认 false，代表按照插入顺序排序)

    Map<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        cache = cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}
