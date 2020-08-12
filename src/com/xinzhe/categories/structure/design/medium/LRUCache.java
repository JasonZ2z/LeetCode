package com.xinzhe.categories.structure.design.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Xin
 * @date 2020/5/12
 * Title : 146. LRU缓存机制
 * Description : 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * link : https://leetcode-cn.com/problems/lru-cache
 * Level : Medium
 */

public class LRUCache {


    Map<Integer, Integer> map;
    LinkedList<Integer> list;
    int size;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();

    }

    public int get(int key) {
        if (list.contains(key)) {
            list.removeIf(a -> a == key);
            list.addLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (list.contains(key)) {
            list.removeIf(a -> a == key);
        }
        if (list.size() == size) {
            list.removeFirst();
        }
        list.addLast(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }
}
