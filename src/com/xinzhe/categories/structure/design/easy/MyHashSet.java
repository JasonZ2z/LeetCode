package com.xinzhe.categories.structure.design.easy;

import java.util.LinkedList;

/**
 * @author Xin
 * @date 2020/5/12
 * Title : 705. 设计哈希集合
 * Description : 不使用任何内建的哈希表库设计一个哈希集合
 *              add(value)：向哈希集合中插入一个值。
 *              contains(value) ：返回哈希集合中是否存在这个值。
 *              remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * link : https://leetcode-cn.com/problems/design-hashset
 * Level : Easy
 */

public class MyHashSet {
    private Bucket[] buckets;
    private int range;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.range = 769;
        this.buckets = new Bucket[range];
        for (int i = 0; i < range; ++i) {
            buckets[i] = new Bucket();
        }
    }

    protected int hash(int key) {
        return key % range;
    }

    public void add(int key) {
        int hash_index = hash(key);
        buckets[hash_index].insert(key);
    }

    public void remove(int key) {
        int hash_index = hash(key);
        buckets[hash_index].delete(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash_index = hash(key);
        return buckets[hash_index].exists(key);
    }

    class Bucket {
        LinkedList<Integer> container;

        public Bucket() {
            this.container = new LinkedList<>();
        }

        public void insert(Integer key) {
            int index = container.indexOf(key);
            if(index == -1) {
                container.addFirst(key);
            }
        }

        public void delete(Integer key) {
            container.remove(key);
        }

        public boolean exists(Integer key) {
            int index = container.indexOf(key);
            return index != -1;
        }
    }
}
