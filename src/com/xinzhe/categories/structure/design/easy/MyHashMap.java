package com.xinzhe.categories.structure.design.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xin
 * @date 2020/5/12
 * Title : 706. 设计哈希映射
 * Description : 不使用任何内建的哈希表库设计一个哈希映射
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 * link : https://leetcode-cn.com/problems/design-hashmap
 * Level : Easy
 */
//todo undo
public class MyHashMap {

    List<int[]> list;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        list = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (list.size() == 0) {
            list.add(new int[]{key, value});
        } else {
            for (int[] arr : list) {
                if (arr[0] == key) {
                    arr[1] = value;
                    return;
                }
            }
            list.add(new int[]{key, value});
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        //return list.stream().filter(a -> a[0] == key).findFirst().get()[1];
        for (int[] arr : list) {
            if (arr[0] == key) {
                return arr[1];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        list.removeIf(a -> a[0] == key);
    }
}
