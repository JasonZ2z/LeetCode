package com.xinzhe.categories.structure.design.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Xin
 * @date 2020/10/31
 * Title : 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * Description : 设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。注意: 允许出现重复元素。
 *          insert(val)：向集合中插入元素 val。
 *          remove(val)：当 val 存在时，从集合中移除一个 val。
 *          getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * link : https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * Level : Hard
 */
//todo need to review
public class RandomizedCollection {
    /** Initialize your data structure here. */
    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(map.containsKey(val)) {
            HashSet<Integer> set = map.get(val);
            set.add(list.size() - 1);
            map.put(val, set);
            return false;
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(list.size() - 1);
            map.put(val, set);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            HashSet<Integer> set = map.get(val);
            int index;
            if(set.size() > 1) {
               index = set.iterator().next();
               set.remove(index);
            } else {
                index = set.iterator().next();
                map.remove(val);
            }
            if(index == list.size() - 1) {
                list.remove(list.size() - 1);
            } else {
                int newIndex = list.size() - 1;
                int value = list.remove(list.size() - 1);
                HashSet<Integer> newSet = map.get(value);
                newSet.remove(newIndex);
                newSet.add(index);
                list.set(index, value);

            }
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        Random ran = new Random();
        return list.get(ran.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        System.out.println(rc.insert(10));
        System.out.println(rc.insert(10));
        System.out.println(rc.insert(20));
        System.out.println(rc.insert(20));
        System.out.println(rc.insert(30));
        System.out.println(rc.insert(30));
        System.out.println(rc.remove(10));
        System.out.println(rc.remove(10));
        System.out.println(rc.remove(30));
        System.out.println(rc.remove(30));
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
    }
}
