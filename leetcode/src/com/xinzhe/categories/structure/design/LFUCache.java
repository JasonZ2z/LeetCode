package com.xinzhe.categories.structure.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/4/5 21:18
 * Title : 460. LFU缓存
 * Description : 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *              get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 *              put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 * link : https://leetcode-cn.com/problems/lfu-cache
 * Level : Hard
 */
//todo undo
public class LFUCache {
    int size;
    Map<Integer, List<Integer>> map;
    public LFUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(size);
    }

    public int get(int key) {
        List<Integer> list = map.get(key);
        if(list == null) {
            return -1;
        } else {
            plusOperate();
            list.set(1, 0);
            map.put(key,list);
            return list.get(0);
        }

    }

    private int plusOperate() {
        if(map.size() == 0) return 0;
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            int f = value.get(1) + 1;
            value.set(1, f);
            if(f > max){
                max = f;
                res = key;
            }
        }
        return res;
    }

    public void put(int key, int value) {
        int max = plusOperate();
        if(get(key) != -1){
            List<Integer> preValue = map.get(key);
            preValue.set(0, value);
            preValue.set(1, 0);
            map.put(key, preValue);
        } else {
            if (map.size() >= size) {
                map.entrySet().removeIf(entry -> entry.getKey() == max);
            }
            map.put(key, Arrays.asList(value, 0));
        }
    }

    public void printcache (){
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            System.out.println("key: " + key + " value: " + value.get(0) + " f: " + value.get(1));
        }
        System.out.println("----------------------------");
    }
}
