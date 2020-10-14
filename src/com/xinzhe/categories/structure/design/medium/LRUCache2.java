package com.xinzhe.categories.structure.design.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/10/14
 * Title : 146. LRU缓存机制
 * Description : 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *              获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *              写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * link : https://leetcode-cn.com/problems/lru-cache
 * Level : Medium
 */

public class LRUCache2 {
    //LinkedHashMap
    //LinkedHashMap的有序可以按两种顺序排列，一种是按照插入的顺序，一种是按照读取的顺序
    //LinkedHashMap 的构造函数, accessOrder(默认 false，代表按照插入顺序排序)
    Map<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
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
